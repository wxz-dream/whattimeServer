package com.setsail.web.android.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.UserShareAlarmService;

@Controller
@RequestMapping("/android/market/")
public class MarketController {
	
	@Autowired
	private UserShareAlarmService userShareAlarmService;

	/**
	 * 获取商城提醒集合
	 * @param userUuid
	 * @param mime
	 * @param cateUuid
	 * @param scope
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "getMarketAlarm")
	@ResponseBody
	public String getMarketAlarm(String userUuid, String mime, Integer cateId, 
			String scope, Long startTime, Long endTime, Integer page){
		
		SystemState systemState = userShareAlarmService.alarmShareFindByPage(userUuid, scope, 
						cateId, startTime, endTime, page);
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取某人提醒集合
	 * @param userUuid
	 * @param manUuid
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "getManAlarm")
	@ResponseBody
	public String getManAlarm(String userUuid, String manUuid, Long startTime, Long endTime, Integer page){
		
		SystemState systemState = userShareAlarmService.alarmShareFindByPage(manUuid, startTime, endTime, page);
		return JSON.toJSONString(systemState);
	}
}
