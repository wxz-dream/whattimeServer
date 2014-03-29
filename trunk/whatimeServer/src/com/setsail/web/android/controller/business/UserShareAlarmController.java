package com.setsail.web.android.controller.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.setsail.entity.business.UserShareAlarm;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.UserShareAlarmService;
/**
 * @desc 用户分享提醒的控制器
 * @author snow
 * @date 2014-03-15
 */
@Controller
@RequestMapping({"/android/userShareAlarm/"})
public class UserShareAlarmController {
	
	private Logger logger = Logger.getLogger(UserShareAlarmController.class);
	
	@Autowired
	private UserShareAlarmService userShareAlarmService;
	
	/**
	 * 添加提醒
	 * @param userUuid
	 * @param mime
	 * @param userShare
	 * @return
	 */
	@RequestMapping(value = "alarmShareAdd", method = RequestMethod.POST)
	@ResponseBody
	public String alarmShareAdd(String userUuid,String mime,String userShareAlarm){
		logger.info(" into UserShareAlarmController.alarmShareAdd");
		UserShareAlarm userShare = JSONArray.parseObject(userShareAlarm, UserShareAlarm.class);
		SystemState systemState = userShareAlarmService.alarmShareAddOrUpdate(userShare);
		logger.info(" out UserShareAlarmController.alarmShareAdd");
		return JSON.toJSONString(systemState);
	}
	
	public static void main(String[] args) {
		System.out.println("====");
		UserShareAlarmController u =new UserShareAlarmController();
		String alarm = "{\"alarmTime\":1395502800952,\"createTime\":1395502644604,\"des\":\"vuvuvubu\",\"endTime\":1396107420132,\"froms\":1,\"id\":2,\"isDel\":false,\"isEndJoin\":false,\"isOpen\":true,\"maxJoinNum\":10000,\"share\":\"0\",\"taskId\":2,\"taskUuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\",\"tasks\":[{\"address\":\"uguvuv&\",\"alarmId\":2,\"alarmTime\":1395502800952,\"alarmUuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\",\"delayMinute\":1,\"delayOrder\":1,\"delayType\":1,\"des\":\"fyfufuf7\",\"id\":2,\"isDel\":false,\"isOpen\":true,\"music\":\"content://settings/system/alarm_alert\",\"notice\":\"jvjvjvuv\",\"playType\":0,\"repeatType\":1,\"shake\":true,\"title\":\"yufyfyw\",\"uuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\"}],\"title\":\"yvyvyv\",\"type\":0,\"uptTime\":1395502690938,\"uuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\"}";
		UserShareAlarm  ss = JSONObject.parseObject(alarm, UserShareAlarm.class);
		u.alarmShareAdd("", "", alarm);
		System.out.println("===="+ss.getAlarmTime());
	}
	
	/**
	 * 修改提醒
	 * @param userUuid
	 * @param mime
	 * @param userShare
	 * @return
	 */
	@RequestMapping(value = "alarmShareEdit", method = RequestMethod.POST)
	@ResponseBody
	public String alarmShareEdit(String userUuid,String mime,String userShareAlarm){
		logger.info(" into UserShareAlarmController.alarmShareEdit");
		UserShareAlarm alarm = JSONArray.parseObject(userShareAlarm, UserShareAlarm.class);
		SystemState systemState = userShareAlarmService.alarmShareAddOrUpdate(alarm);
		logger.info(" out UserShareAlarmController.alarmShareEdit");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 删除提醒
	 * @param userUuid
	 * @param mime
	 * @param alarm_uuid
	 * @return
	 */
	@RequestMapping(value = "alarmShareDelete", method = RequestMethod.POST)
	@ResponseBody
	public String alarmShareDelete(String userUuid,String mime,String alarmUuid){
		logger.info(" into UserShareAlarmController.alarmShareDelete");
		SystemState systemState = userShareAlarmService.alarmShareDelete(alarmUuid);
		logger.info(" out UserShareAlarmController.alarmShareDelete");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取最后一次同步时间
	 * @param userUuid
	 * @param mime
	 * @return
	 */
	@RequestMapping(value = "alarmShareGetLastSyncTime", method = RequestMethod.POST)
	@ResponseBody
	public String alarmShareGetLastSyncTime(String userUuid,String mime){
		logger.info(" into UserShareAlarmController.alarmShareGetLastSyncTime");
		SystemState systemState = userShareAlarmService.alarmShareGetLastSyncTime(userUuid);
		logger.info(" out UserShareAlarmController.alarmShareGetLastSyncTime");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取同步信息
	 * @param userUuid
	 * @param mime
	 * @param sync_time
	 * @return
	 */
	@RequestMapping(value = "alarmShareSync", method = RequestMethod.POST)
	@ResponseBody
	public String alarmShareSync(String userUuid,String mime,long syncTime){
		
		logger.info(" into UserShareAlarmController.alarmShareSync");
		SystemState systemState = userShareAlarmService.alarmShareSync(userUuid,syncTime);
		logger.info(" out UserShareAlarmController.alarmShareSync");
		return JSON.toJSONString(systemState);
	}

}
