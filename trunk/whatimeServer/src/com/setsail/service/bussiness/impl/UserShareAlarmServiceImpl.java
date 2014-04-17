package com.setsail.service.bussiness.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.business.JoinRelation;
import com.setsail.entity.business.UserShareAlarm;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.business.JoinRelationRepository;
import com.setsail.repository.business.UserShareAlarmRepository;
import com.setsail.service.bussiness.UserShareAlarmService;
import com.setsail.util.SstringUtils;

@Service("userShareAlarmService")
public class UserShareAlarmServiceImpl implements UserShareAlarmService {

	@Autowired
	private UserShareAlarmRepository userShareAlarmRepository;

	@Autowired
	private JoinRelationRepository joinRelationRepository;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alarmShareAddOrUpdate(UserShareAlarm userShare) {
		userShare.setUptTime((new Date()).getTime());
		userShare.setSyncTime((new Date()).getTime());
		userShare = userShareAlarmRepository.save(userShare);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userShare);
		return systemState;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alarmShareDelete(String alarmUuid) {
		userShareAlarmRepository.delete(alarmUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		return systemState;
	}

	@Override
	public SystemState alarmShareGetLastSyncTime(String userUuid) {
		UserShareAlarm userShare = userShareAlarmRepository
				.findAlarmShareLastByUserUuid(userUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		if (userShare != null) {
			systemState
					.setResInfo("{syncTime:" + userShare.getSyncTime() + "}");
		}
		return systemState;
	}

	@Override
	public SystemState alarmShareSync(String userUuid, long syncTime) {
		List<UserShareAlarm> userLocals = userShareAlarmRepository
				.findAlarmShareLastBySync(userUuid, syncTime);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userLocals);
		return systemState;
	}

	@Override
	public SystemState alarmShareFindByPage(String userUuid, String scope,
			Integer cateId, Long startTime, Long endTime, Integer page) {
		// TODO
		int pageSize = /*
						 * Integer.valueOf(PropertiesUtil.getPropertiesValue(
						 * "alarm.pageSize"));
						 */20;
		PageRequest pageRequest = new PageRequest(page, pageSize);
		List<UserShareAlarm> userShareAlarms;

		if (SstringUtils.isEmpty(scope)) {
			userShareAlarms = userShareAlarmRepository
					.findUserShareAlarmByCateIdAndAlarmTimeAfterAndAlarmTimeBeforeAndUuidEqualsOwerUuidOrderByAlarmTimeDesc(
							cateId, startTime, endTime, pageRequest);
		} else {
			userShareAlarms = userShareAlarmRepository
					.findByScopeAndCateIdAndAlarmTimeAfterAndAlarmTimeBeforeAndUuidEqualsOwerUuidOrderByAlarmTimeDesc(
							scope, cateId, startTime, endTime, pageRequest);
		}
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userShareAlarms);
		return systemState;
	}

	@Override
	public SystemState alarmShareFindByPage(String manUuid, Long startTime,
			Long endTime, Integer page) {

		// TODO
		int pageSize = /*
						 * Integer.valueOf(PropertiesUtil.getPropertiesValue(
						 * "alarm.pageSize"));
						 */20;
		PageRequest pageRequest = new PageRequest(page, pageSize);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		List<UserShareAlarm> userShareAlarms;

		userShareAlarms = userShareAlarmRepository
				.findByUserUuidAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(
						manUuid, startTime, endTime, pageRequest);
		systemState.setResInfo(userShareAlarms);
		return systemState;
	}

	@Override
	public SystemState joinAlarm(String userUuid, String alarmUuid) {

		SystemState systemState = new SystemState(StateEnum.STATE_FAIL);
		UserShareAlarm userShareAlarm = userShareAlarmRepository
				.findOne(alarmUuid);

		if (userShareAlarm == null)
			return systemState;
		// 如果该提醒参加人数已满，返回错误，提示参加人数已满
		if ((userShareAlarm.getJoinNum() == null ? 0 : userShareAlarm
				.getJoinNum() + 1) > userShareAlarm.getMaxJoinNum())
			return systemState;

		JoinRelation jr = joinRelationRepository.findByUserUuidAndAlarmUuid(
				userUuid, alarmUuid);

		if (jr == null) {
			userShareAlarm.setJoinNum(userShareAlarm.getJoinNum() + 1);
			userShareAlarmRepository.save(userShareAlarm);

			jr = new JoinRelation();
			jr.setUuid(UUID.randomUUID().toString().toLowerCase());
			jr.setUserUuid(userUuid);
			jr.setAlarmUuid(alarmUuid);
			joinRelationRepository.save(jr);
		}

		systemState.setState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userShareAlarm);
		return systemState;
	}

	@Override
	public SystemState alarmShareFindFriendsByPage(String userUuid,
			Long startTime, Long endTime, Integer page) {
		int pageSize = 20;
		PageRequest pageRequest = new PageRequest(page, pageSize);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		List<UserShareAlarm> userShareAlarms;

		userShareAlarms = userShareAlarmRepository
				.findUserFriendsAlarms(userUuid,startTime, endTime,pageRequest);
		systemState.setResInfo(userShareAlarms);
		return systemState;
	}

}
