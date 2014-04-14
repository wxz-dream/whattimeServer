package com.setsail.web.android.controller.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.SystemState;
import com.setsail.service.bussiness.UserFriendService;
/**
 * 分类控制器
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
	 * @param userUuid
	 * @param mime
	 * @param friendUuid
	 * @return
	 */
	public String addFriend(String userUuid, String mime, String friendUuid,String remark) {
		logger.info("into UserFriendController.addFriend");
		SystemState systemState = userFriendService.addFriend(userUuid, mime, friendUuid,remark);
		logger.info("out UserFriendController.addFriend");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取好友申请列表
	 * @param userUuid
	 * @param mime
	 * @param friendReqUuid
	 * @param access
	 * @return
	 */
	public String addMyFriends(String userUuid, String mime,
			String friendReqUuid, int access,String uuid) {
		logger.info("into UserFriendController.addMyFriends");
		SystemState systemState = userFriendService.addMyFriends(userUuid, mime, friendReqUuid, access,uuid);
		logger.info("out UserFriendController.addMyFriends");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 操作好友申请列表
	 * @param userUuid
	 * @param mime
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public String findFriendsAlarm(String userUuid, String mime, long startTime,
			long endTime, int page) {
		logger.info("into UserFriendController.findFriendsAlarm");
		SystemState systemState = userFriendService.findFriendsAlarm(userUuid, mime, startTime, endTime, page);
		logger.info("out UserFriendController.findFriendsAlarm");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取好友列表
	 * @param userUuid
	 * @return
	 */
	public String findMyFriends(String userUuid) {
		logger.info("into UserFriendController.findMyFriends");
		SystemState systemState = userFriendService.findMyFriends(userUuid);
		logger.info("out UserFriendController.findMyFriends");
		return JSON.toJSONString(systemState);
	}

	/**
	 * 获取朋友圈提醒集合
	 * @param userUuid
	 * @param mime
	 * @return
	 */
	public String myAddFriends(String userUuid, String mime) {
		logger.info("into UserFriendController.myAddFriends");
		SystemState systemState = userFriendService.myAddFriends(userUuid, mime);
		logger.info("out UserFriendController.myAddFriends");
		return JSON.toJSONString(systemState);
	}

}
