package com.setsail.service.bussiness.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.business.UserShareAlarm;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.business.UserShareAlarmRepository;
import com.setsail.service.bussiness.UserShareAlarmService;
import com.setsail.util.SstringUtils;

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
		if(userShare!=null)
		{
			systemState.setResInfo("{syncTime:"+userShare.getSyncTime()+"}");
		}
		return systemState;
	}


	@Override
	public SystemState alarmShareSync(String userUuid, long syncTime) {
		List<UserShareAlarm> userLocals = userShareAlarmRepository.findAlarmShareLastBySync(userUuid,syncTime);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userLocals);
		return systemState;
	}


	@Override
	public SystemState alarmShareFindByPage(String userUuid, String scope, Integer cateId,
			Long startTime, Long endTime, Integer page) {
		//TODO
		int pageSize = /*Integer.valueOf(PropertiesUtil.getPropertiesValue("alarm.pageSize"));*/20;
		PageRequest pageRequest = new PageRequest(page, pageSize);
		List<UserShareAlarm> userShareAlarms;
		
		if(SstringUtils.isEmpty(scope)) {
			userShareAlarms = userShareAlarmRepository.
					findUserShareAlarmByCateIdAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(cateId, 
							startTime, endTime, pageRequest);
		}
		else {
			userShareAlarms = userShareAlarmRepository.
					findByScopeAndCateIdAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(
							scope, cateId, startTime, endTime, pageRequest);
		}
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(userShareAlarms);
		return systemState;
	}


	@Override
	public SystemState alarmShareFindByPage(String manUuid, Long startTime,
			Long endTime, Integer page) {
		
		//TODO
		int pageSize = /*Integer.valueOf(PropertiesUtil.getPropertiesValue("alarm.pageSize"));*/20;
		PageRequest pageRequest = new PageRequest(page, pageSize);
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		List<UserShareAlarm> userShareAlarms;
		
		userShareAlarms = userShareAlarmRepository.
				findByUserUuidAndAlarmTimeAfterAndAlarmTimeBeforeOrderByAlarmTimeDesc(manUuid, 
						startTime, endTime, pageRequest);
		systemState.setResInfo(userShareAlarms);
		return systemState;
	}
	
}
