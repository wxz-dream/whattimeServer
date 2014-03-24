package com.setsail.repository;

import java.util.Iterator;
import java.util.List;

public interface BaseRepository<T, U extends java.io.Serializable>{
	
	/**
	 * 查询所有的记录
	 * @return
	 */
	public abstract List<T> findAll();
	
	/**
	 * 查询单个记录
	 * @param uuid 主键
	 * @return
	 */
	public abstract T findOne(U uuid);
	
	/**
	 * 持久化实体
	 * @param entity
	 * @return
	 */
	public abstract void save(T entity);
	
	/**
	 * 持久化实体
	 * @param entity
	 * @return
	 */
	public abstract T saveAndFlush(T entity);
	
	/**
	 * 批量保存
	 * @param entitys
	 */
	public abstract void save(Iterator<T> entitys);
	
	public abstract void delete(T entity);
	
	public abstract void delete(String uuid);
}
