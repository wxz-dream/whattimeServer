package com.setsail.repository;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

@SuppressWarnings("unchecked")
public class BaseRepositoryImpl<T, U extends Serializable>{
	
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	public List<T> findAll() {
		return null;
	}

	public T findOne(U uuid) {
		return null;
	}

	public void save(T entity) {
		hibernateTemplate.save(entity);
	}
	
	public T saveAndFlush(T entity) {
		return (T) hibernateTemplate.merge(entity);
	}

	public void save(Iterator<T> entitys) {
	}

	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	public void delete(String uuid) {
	}

}
