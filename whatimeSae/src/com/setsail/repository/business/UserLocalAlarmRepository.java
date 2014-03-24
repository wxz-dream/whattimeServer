package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserLocalAlarm;

public interface UserLocalAlarmRepository extends PagingAndSortingRepository<UserLocalAlarm, String> {
}