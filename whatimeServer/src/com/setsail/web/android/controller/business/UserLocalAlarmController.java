package com.setsail.web.android.controller.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.setsail.entity.business.UserLocalAlarm;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.UserLocalAlarmService;
/**
 * 用户非分享提醒
 * @author devilangelxpf
 *
 */
@Controller
@RequestMapping("/android/userLocalAlarm/")
public class UserLocalAlarmController {
	
	private Logger logger = Logger.getLogger(UserLocalAlarmController.class);
	
	@Autowired
	private UserLocalAlarmService userLocalAlarmService;
	
	/**
	 * 添加提醒
	 * @param userUuid
	 * @param mime
	 * @param userLocal
	 * @return
	 */
	@RequestMapping(value = "alarmLocalAdd", method = RequestMethod.POST)
	@ResponseBody
	public String alarmLocalAdd(String userUuid,String mime,String userLocalAlarm){
		logger.info(" into UserLocalAlarmController.alarmLocalAdd");
		UserLocalAlarm userLocal = JSONArray.parseObject(userLocalAlarm, UserLocalAlarm.class);
		SystemState systemState = userLocalAlarmService.alarmLocalAddOrUpdate(userLocal);
		logger.info(" out UserLocalAlarmController.alarmLocalAdd");
		return JSON.toJSONString(systemState);
	}
	/**
	 * 修改提醒
	 * @param userUuid
	 * @param mime
	 * @param userLocal
	 * @return
	 */
	@RequestMapping(value = "alarmLocalEdit", method = RequestMethod.POST)
	@ResponseBody
	public String alrmLocalEdit(String userUuid,String mime,String userLocalAlarm){
		logger.info(" into UserLocalAlarmController.alarmLocalEdit");
		UserLocalAlarm alarm = JSONArray.parseObject(userLocalAlarm, UserLocalAlarm.class);
		SystemState systemState = userLocalAlarmService.alarmLocalAddOrUpdate(alarm);
		logger.info(" out UserLocalAlarmController.alarmLocalEdit");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 删除提醒
	 * @param userUuid
	 * @param mime
	 * @param alarm_uuid
	 * @return
	 */
	@RequestMapping(value = "alarmLocalDelete", method = RequestMethod.POST)
	@ResponseBody
	public String alarmLocalDelete(String userUuid,String mime,String alarmUuid){
		logger.info(" into UserLocalAlarmController.alarmLocalDelete");
		SystemState systemState = userLocalAlarmService.alarmLocalDelete(alarmUuid);
		logger.info(" out UserLocalAlarmController.alarmLocalDelete");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取最后一次同步时间
	 * @param userUuid
	 * @param mime
	 * @return
	 */
	@RequestMapping(value = "alarmLocalGetLastSyncTime", method = RequestMethod.POST)
	@ResponseBody
	public String alrmLocalGetLastSyncTime(String userUuid,String mime){
		logger.info(" into UserLocalAlarmController.alarmLocalGetLastSyncTime");
		SystemState systemState = userLocalAlarmService.alarmLocalGetLastSyncTime(userUuid);
		logger.info(" out UserLocalAlarmController.alarmLocalGetLastSyncTime");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取同步信息
	 * @param userUuid
	 * @param mime
	 * @param sync_time
	 * @return
	 */
	public String alrmLocalSync(String userUuid,String mime,long sync_time){
		
		
		return "";
	}

}
