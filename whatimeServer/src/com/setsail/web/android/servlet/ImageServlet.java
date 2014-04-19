package com.setsail.web.android.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.ApkVersion;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.User;
import com.setsail.repository.ApkVersionRepository;
import com.setsail.repository.user.UserRepository;
import com.setsail.util.BCSUtil;
import com.setsail.util.SstringUtils;

@WebServlet(name = "imageServlet", urlPatterns = "/file", loadOnStartup = 2)
@MultipartConfig(maxFileSize = 100 * 1024 * 1024)
public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = -5363002601681374598L;
	
	private String USER_UUID = "userUuid";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApkVersionRepository apkVersionRepository;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		
		if (userRepository == null || apkVersionRepository == null) {
			ApplicationContext ac = WebApplicationContextUtils
					.getWebApplicationContext(req.getServletContext());
			userRepository = ac.getBean(UserRepository.class);
			apkVersionRepository = ac.getBean(ApkVersionRepository.class);
			ac = null;
		}
		
		String fileType = req.getParameter("fileType"); //文件类型
		String userId = SstringUtils.getNotNull(req.getParameter(USER_UUID));
		String apkVersion = req.getParameter("version");
		Collection<Part> parts = req.getParts();
		
		//保存文件
		resp.getWriter().write(JSON.toJSONString(
				persite(fileType, userId.isEmpty() ? apkVersion : userId, parts)
				));
		resp.getWriter().close();
	}
	
	/**
	 * 保存文件
	 * @param fileType 文件类型  头像{@link com.setsail.util.BCSUtil.FILE_TYPE_IMG }
	 * <br> 客户端文件{@link com.setsail.util.BCSUtil.FILE_TYPE_APK }
	 * @param userId 用户主键或客户端版本号
	 * @param parts
	 * @return
	 */
	private SystemState persite(String fileType, String userId, Collection<Part> parts){
		//用户头像
		if(BCSUtil.FILE_TYPE_IMG.equalsIgnoreCase(fileType)){
			User user = userRepository.findOne(userId);
			if(user == null) return new SystemState(StateEnum.STATE_NOLOGIN);
			String object = SstringUtils.getNotNull(saveFile2BCS(parts, BCSUtil.FILE_TYPE_IMG, user.getObject()));
			if(!object.isEmpty()){
				user.setUserphotoUri(BCSUtil.generateUrl(object));
				user.setObject(getObject(object));
				userRepository.save(user);
				SystemState ss = new SystemState(StateEnum.STATE_SUCCESS);
				ss.setResInfo(user.getUserphotoUri());
				return ss;
			}
		}
		if(BCSUtil.FILE_TYPE_APK.equalsIgnoreCase(fileType)){
			String object = SstringUtils.getNotNull(saveFile2BCS(parts, BCSUtil.FILE_TYPE_APK, null));
			if(!object.isEmpty()){
				ApkVersion av = new ApkVersion();
				av.setUrl(BCSUtil.generateUrl(object));
				av.setUuid(UUID.randomUUID().toString());
				av.setVersion(userId);
				apkVersionRepository.save(av);
				return new SystemState(StateEnum.STATE_SUCCESS);
			}
		}
		return new SystemState(StateEnum.STATE_FAIL);
	}

	private String saveFile2BCS(Collection<Part> parts, String fileType, String object) {
		
		Iterator<Part> iterator = parts.iterator(); 
		while(iterator.hasNext()) {
			Part part = iterator.next();
			if(part.getContentType() != null && !part.getContentType().contains("text/plain")){
				try {
					return BCSUtil.putObject(part, fileType, object);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private final String getObject(String object){
		return SstringUtils.substring(object, object.lastIndexOf("/") + 1);
	}

}
