package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.AlarmCategory;

public interface AlarmCategoryRepository extends PagingAndSortingRepository<AlarmCategory, String> {
}