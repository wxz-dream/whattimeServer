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

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

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
import com.setsail.util.SstringUtils;
import com.setsail.web.android.annotation.Auth;

/**
 * 
 * @WebFilter将一个实现了javax.servlet.Filte接口的类定义为过滤器组件 属性filterName声明过滤器的名称,可选
 *                                                 属性urlPatterns指定要过滤
 *                                                 的URL模式,也可使用属性value来声明
 *                                                 .(指定要过滤的URL模式是必选属性)
 * 
 *                                                 <p>
 *                                                 功能描述: 过滤器
 *                                                 </p>
 * @author: zhangyajie
 * @version 0.1
 */
@WebFilter(urlPatterns = "/*")
public class UserFilter implements Filter {

	// private Logger logger = Logger.getLogger(getClass());
	private String[] noLoginAuthURL = {};
	private String[] controllerPackage = new String[] {
			"com.setsail.web.android.controller.user.UserController",
			"com.setsail.web.android.controller.business.UserShareAlarmController",
			"com.setsail.web.android.controller.business.UserLocalAlarmController" };
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
		noLoginAuthURL = getNoLoginURL(controllerPackage);
		System.out.println("登陆拦截的链接初始化完毕" + Arrays.toString(noLoginAuthURL));
		controllerPackage = null;
		// logger.info("登陆拦截的链接初始化完毕:" + Arrays.toString(noLoginAuthURL));
	}

	private String[] getNoLoginURL(String[] classNames) {
		if (classNames != null) {

			ArrayList<String> urList = new ArrayList<String>();

			for (String className : classNames) {
				@SuppressWarnings("rawtypes")
				Class controller = null;

				try {
					controller = Class.forName(className);
				} catch (SecurityException e) {
					e.printStackTrace();
					// logger.error(e);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					// logger.error(e);
				}
				if (controller != null) {

					Controller c = AnnotationUtils.findAnnotation(controller,
							Controller.class);

					if (c != null) {
						// controller类RequestMapping注解
						RequestMapping crm = AnnotationUtils.findAnnotation(
								controller, RequestMapping.class);
						// url前缀
						String[] prefixs = crm == null ? new String[0] : crm
								.value();

						Method[] ms = controller.getMethods();
						if (ms != null) {
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
						}
					}
				}
			}
			return urList.toArray(noLoginAuthURL);
		}
		return new String[0];
	}
}
