/**
 * Created on 2013-12-4 下午5:13:22 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.util;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

/**
 * 作成日期： 2013-12-4
 * <p>
 * 功能描述: [所属模块及功能描述]
 * </p>
 * 
 * @author: zhangyajie
 * @version 0.1
 */
public class JSONPropertyPreFilter implements PropertyPreFilter {

	private final Class<?> clazz;
	private final Set<String> includes = new HashSet<String>();

	/**
	 * <p>
	 * 描述:[排除属性]
	 * </p>
	 * 
	 * @coustructor 方法.
	 */
	public JSONPropertyPreFilter(Class<?> clazz, String... properties) {
		this.clazz = clazz;
		for (String item : properties) {
			if (item != null) {
				this.includes.add(item);
			}
		}
	}

	@Override
	public boolean apply(JSONSerializer serializer, Object source, String name) {

		if (source == null) {
			return true;
		}

		if (clazz != null && !clazz.isInstance(source)) {
			return true;
		}
		
		if (this.includes.contains(name)) {
			return false;
		}
		return true;
	}

}
