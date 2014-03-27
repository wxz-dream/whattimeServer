package com.setsail.service.bussiness;

import com.setsail.entity.response.SystemState;


/**
 * 分类服务
 * @author devilangelxpf
 *
 */
public interface CategoryService {
	
	/**
	 * 获取表中分类数量
	 * @return
	 */
	public int getCateCount();
	
	public SystemState getAllCategory();

}
