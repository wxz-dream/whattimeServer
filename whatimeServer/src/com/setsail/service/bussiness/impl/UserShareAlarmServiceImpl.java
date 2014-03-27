package com.setsail.service.bussiness.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.business.UserShareAlarm;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.business.UserShareAlarmRepository;
import com.setsail.service.bussiness.UserShareAlarmService;

@Service("userShareAlarmService")
public class UserShareAlarmServiceImpl implements UserShareAlarmService {

	@Autowired
	private UserShareAlarmRepository userShareAlarmRepository;
	
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
		UserShareAlarm userShare = userShareAlarmRepository.findAlarmShareLastByUserUuid(userUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userShare);
		return systemState;
	}
	
}