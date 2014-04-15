package com.setsail.service.bussiness;

import com.setsail.entity.response.SystemState;

/**
 * 添加好友
 * @author snow
 *
 */
public interface UserFriendService {

	/**
	 * 添加好友
	 * @param userUuid
	 * @param mime
	 * @param friendUuid
	 * @param remark 
	 * @return
	 */
	public SystemState addFriendReq(String userUuid,String mime,String friendUuid, String remark);
	
	/**
	 * 获取好友申请列表
	 * @param userUuid
	 * @param mime
	 * @return
	 */
	public SystemState findMyAddFriendsReq(String userUuid,String mime);
	
	/**
	 * 操作好友申请列表
	 * @param userUuid
	 * @param mime
	 * @param friendReqUuid
	 * @param access
	 * @param uuid 
	 * @return
	 */
	public SystemState operaMyFriendReq(String userUuid,String mime,int access, String uuid);
	
	/**
	 * 获取好友列表
	 * @param userUccess
	 * @return
	 */
	public SystemState findMyFriends(String userUuid);
	
	/**
	 * 获取朋友圈提醒集合
	 * @param userUuid
	 * @param mime
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public SystemState findFriendsAlarm(String userUuid,String mime,long startTime,long endTime,int page);
}
