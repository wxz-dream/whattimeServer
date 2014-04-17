package com.setsail.web.android.controller.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.UserFriendService;

/**
 * 分类控制器
 * 
 * @author devilangelxpf
 * 
 */
@Controller
@RequestMapping("/android/friend/")
public class UserFriendController {

	private Logger logger = Logger.getLogger(UserFriendController.class);

	@Autowired
	private UserFriendService userFriendService;

	/**
	 * 添加好友
	 * 
	 * @param userUuid
	 * @param mime
	 * @param friendUuid
	 * @return
	 */
	@RequestMapping(value = "addFriendReq", method = RequestMethod.POST)
	@ResponseBody
	public String addFriendReq(String userUuid, String mime, String friendUuid,
			String remark) {
		logger.info("into UserFriendController.addFriend");
		SystemState systemState = userFriendService.addFriendReq(userUuid,
				mime, friendUuid, remark);
		logger.info("out UserFriendController.addFriend");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取好友申请列表
	 * 
	 * @param userUuid
	 * @param mime
	 * @param friendReqUuid
	 * @param access
	 * @return
	 */
	@RequestMapping(value = "findMyAddFriendsReq", method = RequestMethod.POST)
	@ResponseBody
	public String findMyAddFriendsReq(String userUuid, String mime) {
		logger.info("into UserFriendController.addMyFriends");
		SystemState systemState = userFriendService.findMyAddFriendsReq(
				userUuid, mime);
		logger.info("out UserFriendController.addMyFriends");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 操作好友申请列表
	 * 
	 * @param userUuid
	 * @param mime
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "operaMyFriendReq", method = RequestMethod.POST)
	@ResponseBody
	public String operaMyFriendReq(String userUuid, String mime, int access, String uuid) {
		logger.info("into UserFriendController.addMyFriends");
		SystemState systemState = userFriendService.operaMyFriendReq(userUuid,
				mime, access, uuid);
		logger.info("out UserFriendController.addMyFriends");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取好友提醒列表
	 * 
	 * @param userUuid
	 * @param mime
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "findFriendsAlarm", method = RequestMethod.POST)
	@ResponseBody
	public String findFriendsAlarm(String userUuid, String mime,
			long startTime, long endTime, int page) {
		logger.info("into UserFriendController.findFriendsAlarm");
		SystemState systemState = userFriendService.findFriendsAlarm(userUuid,
				mime, startTime, endTime, page);
		logger.info("out UserFriendController.findFriendsAlarm");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取好友列表
	 * 
	 * @param userUuid
	 * @return
	 */
	@RequestMapping(value = "findMyFriends", method = RequestMethod.POST)
	@ResponseBody
	public String findMyFriends(String userUuid, String mime) {
		logger.info("into UserFriendController.findMyFriends");
		SystemState systemState = userFriendService.findMyFriends(userUuid);
		logger.info("out UserFriendController.findMyFriends");
		return JSON.toJSONString(systemState);
	}

}
