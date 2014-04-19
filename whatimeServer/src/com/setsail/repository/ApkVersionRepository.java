package com.setsail.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.ApkVersion;

public interface ApkVersionRepository extends PagingAndSortingRepository<ApkVersion, String>{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = false)
	public ApkVersion save(ApkVersion apk);
}
