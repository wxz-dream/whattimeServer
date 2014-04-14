package com.setsail.repository.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.user.Relation;

public interface RelationRepository extends PagingAndSortingRepository<Relation, String> {

	/**
	 * 好友列表
	 * @param userUuid
	 * @return
	 */
	public List<Relation> findRelationByUserUuid(String userUuid);
}