package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserLocalTask;

public interface UserLocalTaskRepository extends PagingAndSortingRepository<UserLocalTask, String> {
}