package com.setsail.repository.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.setsail.entity.user.User;
import com.setsail.repository.BaseRepositoryImpl;
import com.setsail.repository.user.UserRepository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User, String> implements UserRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public User findByUserName(String userName) {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) hibernateTemplate.
				find("from User where userName = ?", userName);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public User findByEmail(String email) {
		return null;
	}

}
