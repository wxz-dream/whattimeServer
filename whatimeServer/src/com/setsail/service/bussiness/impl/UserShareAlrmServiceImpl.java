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
import com.setsail.service.bussiness.UserShareAlrmService;

@Service("userShareAlrmService")
public class UserShareAlrmServiceImpl implements UserShareAlrmService {

	@Autowired
	private UserShareAlarmRepository userShareAlarmRepository;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alrmShareAddOrUpdate(UserShareAlarm userShare) {
		userShare.setUptTime((new Date()).getTime());
		userShare.setSyncTime((new Date()).getTime());
		userShare = userShareAlarmRepository.save(userShare);
		SystemState SystemState = new SystemState(StateEnum.STATE_SUCCESS);
		SystemState.setResInfo(userShare);
		return SystemState;
	}

	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alrmShareDelete(String alarmUuid) {
		userShareAlarmRepository.delete(alarmUuid);
		SystemState SystemState = new SystemState(StateEnum.STATE_SUCCESS);
		return SystemState;
	}


	@Override
	public SystemState alrmShareGetLastSyncTime(String userUuid) {
		UserShareAlarm userShare = userShareAlarmRepository.findAlrmShareLastByUserUuid(userUuid);
		SystemState SystemState = new SystemState(StateEnum.STATE_SUCCESS);
		SystemState.setResInfo(userShare);
		return SystemState;
	}
	
}
