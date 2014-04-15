package com.setsail.repository.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.user.FriendReq;

public interface FriendReqRepository extends PagingAndSortingRepository<FriendReq, String> {

	/**
	 * 
	 * @param userUuid
	 * @param friendUuid
	 * @return
	 */
	public FriendReq findFriendReqByUserUuidAndFriendReqUuid(String userUuid,
			String friendUuid);

	/**
	 * 
	 * @param userUuid
	 * @param accessUntreated
	 */
	public List<FriendReq> findFriendReqByUserUuidAndAccess(String userUuid, int access);

	/**
	 * 
	 * @param userUuid
	 * @param accessUntreated
	 * @return
	 */
	public List<FriendReq> findFriendReqByFriendReqUuidAndAccess(
			String userUuid, int accessUntreated);
	
	public List<FriendReq> findFriendReqByFriendReqUuid(
			String userUuid);
}