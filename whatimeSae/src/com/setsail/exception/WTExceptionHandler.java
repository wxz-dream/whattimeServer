package com.setsail.exception;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
/**
 * 统一的异常处理类
 * @author ZhangYJ
 *
 */
public class WTExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = Logger.getLogger(WTExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse respones, Object obj, Exception ex) {
		
		if(ex == null) return null;
		
		HandlerMethod handlerMethod = null;
		try{
			handlerMethod = (HandlerMethod)obj;
		}catch(Exception e){}
		
		if(handlerMethod == null) return null;
		
		//获取发生异常的方法
		Method method = handlerMethod.getMethod();
		
		if(method == null) return null;
		
		//获得带有ResponseBody注解对象(即返回对象为JSON)
		ResponseBody rb = AnnotationUtils.findAnnotation(method, ResponseBody.class);
		
		//跳转回页面的请求
		if(rb == null){
			//TODO
		}
		
		//返回JSON的请求
		if(rb != null){
			//logger.info(handlerMethod.toString() + " " + ex.getMessage());
			//记录错误日志
			logger.error(handlerMethod.toString(), ex);
			try {
				//返回错误信息(JSON对象)
				respones.getWriter().write(JSON.toJSONString(
						new SystemState(StateEnum.STATE_EXCEPTION)));
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			return new ModelAndView();
		}
		
		//logger.info((request.getRequestURI());
		
		return null;
	}

}
