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
import com.setsail.service.bussiness.UserShareAlrmService;
/**
 * @desc 用户分享提醒的控制器
 * @author snow
 * @date 2014-03-15
 */
@Controller
@RequestMapping("/android/userShareAlarm/")
public class UserShareAlrmController {
	
	private Logger logger = Logger.getLogger(UserShareAlrmController.class);
	
	@Autowired
	private UserShareAlrmService userShareAlrmService;
	
	/**
	 * 添加提醒
	 * @param userUuid
	 * @param mime
	 * @param userShare
	 * @return
	 */
	@RequestMapping(value = "alrmShareAdd", method = RequestMethod.POST)
	@ResponseBody
	public String alrmShareAdd(String userUuid,String mime,String userShareAlarm){
		logger.info(" into UserShareAlrmController.alrmShareAdd");
		UserShareAlarm userShare = JSONArray.parseObject(userShareAlarm, UserShareAlarm.class);
		SystemState systemState = userShareAlrmService.alrmShareAddOrUpdate(userShare);
		logger.info(" out UserShareAlrmController.alrmShareAdd");
		return JSON.toJSONString(systemState);
	}
	
	public static void main(String[] args) {
		System.out.println("====");
		UserShareAlrmController u =new UserShareAlrmController();
		String alarm = "{\"alarmTime\":1395502800952,\"createTime\":1395502644604,\"des\":\"vuvuvubu\",\"endTime\":1396107420132,\"froms\":1,\"id\":2,\"isDel\":false,\"isEndJoin\":false,\"isOpen\":true,\"maxJoinNum\":10000,\"share\":\"0\",\"taskId\":2,\"taskUuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\",\"tasks\":[{\"address\":\"uguvuv&\",\"alarmId\":2,\"alarmTime\":1395502800952,\"alarmUuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\",\"delayMinute\":1,\"delayOrder\":1,\"delayType\":1,\"des\":\"fyfufuf7\",\"id\":2,\"isDel\":false,\"isOpen\":true,\"music\":\"content://settings/system/alarm_alert\",\"notice\":\"jvjvjvuv\",\"playType\":0,\"repeatType\":1,\"shake\":true,\"title\":\"yufyfyw\",\"uuid\":\"d21e4012-df9e-496f-bf52-f198ff32adf9\"}],\"title\":\"yvyvyv\",\"type\":0,\"uptTime\":1395502690938,\"uuid\":\"3bfd19ca-5bc8-48d9-a737-d3095a101504\"}";
		UserShareAlarm  ss = JSONObject.parseObject(alarm, UserShareAlarm.class);
		u.alrmShareAdd("", "", alarm);
		System.out.println("===="+ss.getAlarmTime());
	}
	
	/**
	 * 修改提醒
	 * @param userUuid
	 * @param mime
	 * @param userShare
	 * @return
	 */
	@RequestMapping(value = "alrmShareEdit", method = RequestMethod.POST)
	@ResponseBody
	public String alrmShareEdit(String userUuid,String mime,String userShareAlarm){
		logger.info(" into UserShareAlrmController.alrmShareEdit");
		UserShareAlarm alarm = JSONArray.parseObject(userShareAlarm, UserShareAlarm.class);
		SystemState systemState = userShareAlrmService.alrmShareAddOrUpdate(alarm);
		logger.info(" out UserShareAlrmController.alrmShareEdit");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 删除提醒
	 * @param userUuid
	 * @param mime
	 * @param alarm_uuid
	 * @return
	 */
	@RequestMapping(value = "alrmShareDelete", method = RequestMethod.POST)
	@ResponseBody
	public String alrmShareDelete(String userUuid,String mime,String alarmUuid){
		logger.info(" into UserShareAlrmController.alrmShareDelete");
		SystemState systemState = userShareAlrmService.alrmShareDelete(alarmUuid);
		logger.info(" out UserShareAlrmController.alrmShareDelete");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取最后一次同步时间
	 * @param userUuid
	 * @param mime
	 * @return
	 */
	@RequestMapping(value = "alrmShareGetLastSyncTime", method = RequestMethod.POST)
	@ResponseBody
	public String alrmShareGetLastSyncTime(String userUuid,String mime){
		logger.info(" into UserShareAlrmController.alrmShareGetLastSyncTime");
		SystemState systemState = userShareAlrmService.alrmShareGetLastSyncTime(userUuid);
		logger.info(" out UserShareAlrmController.alrmShareGetLastSyncTime");
		return JSON.toJSONString(systemState);
	}
	
	/**
	 * 获取同步信息
	 * @param userUuid
	 * @param mime
	 * @param sync_time
	 * @return
	 */
	public String alrmShareSync(String userUuid,String mime,long sync_time){
		
		
		return "";
	}

}
