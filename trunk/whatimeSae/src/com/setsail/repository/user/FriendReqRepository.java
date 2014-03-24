package com.setsail.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.user.FriendReq;

public interface FriendReqRepository extends PagingAndSortingRepository<FriendReq, String> {
}