/**
 * Created on 2013-11-6 上午11:28:43 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.web.android.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.User;
import com.setsail.repository.user.UserRepository;
import com.setsail.util.PackageScan;
import com.setsail.util.SstringUtils;
import com.setsail.web.android.annotation.Auth;

/**
 * 
 * @WebFilter将一个实现了javax.servlet.Filte接口的类定义为过滤器组件 
 * 属性filterName声明过滤器的名称,可选属性urlPatterns指定要过滤
 * 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 * 
 * <p>
 * 功能描述: 过滤器
 * </p>
 * @author: zhangyajie
 * @version 0.1
 */
@WebFilter(urlPatterns = "/android/*", servletNames = "wtserver")
public class UserFilter implements Filter {

	private Logger logger = Logger.getLogger(getClass());
	private String[] noLoginAuthURL = {};
	private String basePackage = "com.setsail.web.android.controller";
	private String MIME = "MIME";
	private String UUID = "userUuid";

	@Override
	public void destroy() {
		noLoginAuthURL = null;
		userRepository = null;
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		
		String url = ((HttpServletRequest) request).getServletPath();
		
		// 需要登陆验证
		if (!contains(noLoginAuthURL, url)) {
			String RMIME = SstringUtils.getNotNull(request.getParameter(MIME))
					.isEmpty() ? SstringUtils.getNotNull(request
					.getParameter(MIME.toLowerCase())) : SstringUtils
					.getNotNull(request.getParameter(MIME));
			String RUUID = SstringUtils.getNotNull(request.getParameter(UUID))
					.isEmpty() ? SstringUtils.getNotNull(request
					.getParameter(UUID.toLowerCase())) : SstringUtils
					.getNotNull(request.getParameter(UUID));

			if (userRepository == null) {
				ApplicationContext ac = WebApplicationContextUtils
						.getWebApplicationContext(request.getServletContext());
				userRepository = ac.getBean(UserRepository.class);
				ac = null;
			}
			User user = userRepository.findOne(RUUID);

			// 没有登陆
			if (user == null || !user.getMime().equals(RMIME)) {
				response.getWriter().write(
						JSON.toJSONString(new SystemState(
								StateEnum.STATE_NOLOGIN)));
				return;
			}
		}
		fc.doFilter(request, response);
	}

	/**
	 * 检索url是否在不需要登陆验证的链接数组里
	 * 
	 * @param nologinAuthURL
	 * @param url
	 * @return true : 在|false :不在
	 */
	private boolean contains(String[] nologinAuthURL, String url) {
		if (nologinAuthURL.length > 0) {
			if(url.contains(".")) url = url.substring(0, url.lastIndexOf("."));
			for (String str : nologinAuthURL) {
				if (str.equalsIgnoreCase(url)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		noLoginAuthURL = getNoLoginURL(basePackage);
		System.out.println("login filter init success : " + Arrays.toString(noLoginAuthURL));
		basePackage = null;
		logger.info("loginFilter init success:" + Arrays.toString(noLoginAuthURL));
	}
	
	private String[] getNoLoginURL(String basePackage){
		List<String> urls = new ArrayList<String>(50);
		Set<Class<?>> sets = PackageScan.getClasses(basePackage);
		Iterator<Class<?>> it;
		if(sets != null && (it = sets.iterator()) != null){
			while(it.hasNext()){
				Class<?> controllerClass = it.next();
				Controller controller = AnnotationUtils.findAnnotation(controllerClass, Controller.class);
				if(controller == null) continue;
				Auth auth = AnnotationUtils.findAnnotation(controllerClass, Auth.class);
				if(auth == null) {
					urls.addAll(getNotLoginURLByMethod(controllerClass));
				}
				else {
					urls.addAll(getNotLoginURLByClass(controllerClass));
				}
			}
		}
		urls.add("/file"); urls.add("/whatimeServer/file");//TODO
		return urls.toArray(noLoginAuthURL);
	}

	private List<String> getNotLoginURLByMethod(Class<?> controllerClass) {
		List<String> urList = new ArrayList<String>(10);
		RequestMapping rmc = AnnotationUtils.findAnnotation(controllerClass, RequestMapping.class);
		if(rmc == null) return urList;
		String[] prefixs = rmc.value();
		if(hasLength(prefixs)) return urList;
		Method[] ms = controllerClass.getMethods();
		if(hasLength(ms)) return urList;
		for (Method m : ms) {
			Auth auth = AnnotationUtils.findAnnotation(m,
					Auth.class);
			// 若有Auth注解，则该方法不需要登陆验证
			if (auth != null) {
				RequestMapping rm = AnnotationUtils
						.findAnnotation(m,
								RequestMapping.class);
				if (rm != null) {
					String[] suffixs = rm.value();
					if (suffixs != null) {
						for (String suffix : suffixs) {

							if (prefixs != null
									&& prefixs.length > 0)
								for (String prefix : prefixs) {
									urList.add(prefix
											+ suffix);
								}
							else {
								urList.add(suffix);
							}
						}
					}
				}
			}
		}
		return urList;
	}

	private List<String> getNotLoginURLByClass(
			Class<?> controllerClass) {
		List<String> urList = new ArrayList<String>(10);
		RequestMapping rmc = AnnotationUtils.findAnnotation(controllerClass, RequestMapping.class);
		if(rmc == null) return urList;
		String[] prefixs = rmc.value();
		if(hasLength(prefixs)) return urList;
		Method[] ms = controllerClass.getMethods();
		if(hasLength(ms)) return urList;
		for (Method m : ms) {
			RequestMapping rm = AnnotationUtils.findAnnotation(m, RequestMapping.class);
			if (rm != null) {
				String[] suffixs = rm.value();
				if (suffixs != null) {
					for (String suffix : suffixs) {

						if (prefixs != null
								&& prefixs.length > 0)
							for (String prefix : prefixs) {
								urList.add(prefix
										+ suffix);
							}
						else {
							urList.add(suffix);
						}
					}
				}
			}
		}
		return urList;
	}
	
	private boolean hasLength(Object[] array){
		return array == null || array.length == 0;
	}
	
}
