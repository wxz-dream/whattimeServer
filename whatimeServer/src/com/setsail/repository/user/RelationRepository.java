package com.setsail.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.user.Relation;

public interface RelationRepository extends PagingAndSortingRepository<Relation, String> {
}