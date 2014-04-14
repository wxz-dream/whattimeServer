package com.setsail.service.bussiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setsail.common.Constants;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.FriendReq;
import com.setsail.entity.user.Relation;
import com.setsail.entity.user.User;
import com.setsail.repository.user.FriendReqRepository;
import com.setsail.repository.user.RelationRepository;
import com.setsail.repository.user.UserRepository;
import com.setsail.service.bussiness.UserFriendService;

@Service("userFriendService")
public class UserFriendServiceImpl implements UserFriendService {

	@Autowired
	private FriendReqRepository friendReqRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RelationRepository relationRepository;
	
	@Override
	public SystemState addFriend(String userUuid, String mime, String friendUuid, String remark) {
		
		SystemState systemState = null;
		
		//是否有记录
		FriendReq friendReq = friendReqRepository.findFriendReqByUserUuidAndFriendReqUuid(userUuid,friendUuid);
		if(null!=friendReq && ( friendReq.getAccess()==Constants.ACCESS_AGREE  || friendReq.getAccess()==Constants.ACCESS_UNTREATED)){
			systemState = new SystemState(StateEnum.STATE_SUCCESS);
		}
		try{
			User muser = userRepository.findOne(userUuid);
			friendReq = new FriendReq();
			friendReq.setUserUuid(userUuid);
			friendReq.setNickName(muser.getNickName());
			friendReq.setFriendReqUuid(friendUuid);
			friendReq.setUserphotoUri(muser.getUserphotoUri());
			friendReq.setRemark(remark);
			friendReq.setAccess(Constants.ACCESS_UNTREATED);//未处理
			long time = System.currentTimeMillis();
			friendReq.setRequestTime(time);
			friendReq.setUptTime(time);
			friendReq = friendReqRepository.save(friendReq);
		}catch(Exception e){
			systemState = new SystemState(StateEnum.STATE_FAIL);
		}
		systemState = new SystemState(StateEnum.STATE_SUCCESS);
		return systemState;
	}

	@Override
	public SystemState addMyFriends(String userUuid, String mime,
			String friendReqUuid, int access, String uuid) {
		if("".equals(uuid)){
			return  new SystemState(StateEnum.STATE_FAIL);
		}
		FriendReq friendReq = friendReqRepository.findOne(uuid);
		friendReq.setAccess(access);
		return new SystemState(StateEnum.STATE_SUCCESS);
	}

	@Override
	public SystemState findFriendsAlarm(String userUuid, String mime, long startTime,
			long endTime, int page) {
		List<Relation> list = relationRepository.findRelationByUserUuid(userUuid);
		
		
		
		return null;
	}

	@Override
	public SystemState findMyFriends(String userUuid) {
		List<Relation> list = relationRepository.findRelationByUserUuid(userUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(list);
		return systemState;
	}

	@Override
	public SystemState myAddFriends(String userUuid, String mime) {
		List<FriendReq> list = friendReqRepository.findFriendReqByFriendReqUuidAndAccess(userUuid,Constants.ACCESS_UNTREATED);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(list);
		return systemState;
	}

}
