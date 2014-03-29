package com.setsail.service.bussiness.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.business.UserLocalAlarm;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.business.UserLocalAlarmRepository;
import com.setsail.service.bussiness.UserLocalAlarmService;

@Service("userLocalAlarmService")
public class UserLocalAlarmServiceImpl implements UserLocalAlarmService {

	@Autowired
	private UserLocalAlarmRepository userLocalAlarmRepository;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alarmLocalAddOrUpdate(UserLocalAlarm userLocal) {
		userLocal.setUptTime((new Date()).getTime());
		userLocal.setSyncTime((new Date()).getTime());
		userLocal = userLocalAlarmRepository.save(userLocal);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userLocal);
		return systemState;
	}

	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState alarmLocalDelete(String alarmUuid) {
		userLocalAlarmRepository.delete(alarmUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		return systemState;
	}


	@Override
	public SystemState alarmLocalGetLastSyncTime(String userUuid) {
		UserLocalAlarm userLocal = userLocalAlarmRepository.findAlarmLocalLastByUserUuid(userUuid);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		if(userLocal!=null)
		{
			systemState.setResInfo("{syncTime:"+userLocal.getSyncTime()+"}");
		}
		return systemState;
	}


	@Override
	public SystemState alrmLocalSync(String userUuid, long syncTime) {
		List<UserLocalAlarm> userLocals = userLocalAlarmRepository.findAlarmLocalLastBySync(userUuid,syncTime);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userLocals);
		return systemState;
	}
	
}
