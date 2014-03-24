package com.setsail.repository.business;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.business.JoinRelation;

public interface JoinRelationRepository extends PagingAndSortingRepository<JoinRelation, String> {
}