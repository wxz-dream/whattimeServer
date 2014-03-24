package com.setsail.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.setsail.entity.user.Level;

public interface LevelRepository extends PagingAndSortingRepository<Level, String> {
}