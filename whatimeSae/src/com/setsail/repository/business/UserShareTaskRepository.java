package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.UserShareTask;

public interface UserShareTaskRepository extends PagingAndSortingRepository<UserShareTask, String> {
}