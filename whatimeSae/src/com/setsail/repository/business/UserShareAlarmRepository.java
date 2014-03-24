package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserShareAlarm;

public interface UserShareAlarmRepository extends PagingAndSortingRepository<UserShareAlarm, String> {
}