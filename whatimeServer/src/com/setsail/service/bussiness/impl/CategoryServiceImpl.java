package com.setsail.service.bussiness.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.business.AlarmCategoryRepository;
import com.setsail.service.bussiness.CategoryService;
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private AlarmCategoryRepository alarmCategoryRepository;
	
	@Override
	public int getCateCount() {
		return (int)alarmCategoryRepository.count();
	}

	@Override
	public SystemState getAllCategory() {
		SystemState systemState = new SystemState(StateEnum.STATE_SUCCESS);
		systemState.setResInfo(alarmCategoryRepository.findAll());
		return systemState;
	}

}
