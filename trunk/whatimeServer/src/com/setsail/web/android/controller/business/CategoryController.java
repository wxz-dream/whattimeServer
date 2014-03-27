package com.setsail.web.android.controller.business;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.CategoryService;
/**
 * 分类控制器
 * @author devilangelxpf
 *
 */
@Controller
@RequestMapping("/android/cate/")
public class CategoryController {
	
	private Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService cateService;
	
	/**
	 * 添加提醒
	 * @param userUuid
	 * @param mime
	 * @param userShare
	 * @return
	 */
	@RequestMapping(value = "getSyncCategory", method = RequestMethod.POST)
	@ResponseBody
	public String getSyncCategory(String userUuid,String mime,Integer count){
		logger.info(" into CategoryController.getSyncCategory");
		int myCount = cateService.getCateCount();
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		if(myCount>count)
		{
			systemState = cateService.getAllCategory();
		}
		logger.info(" out CategoryController.getSyncCategory");
		return JSON.toJSONString(systemState);
	}

}
