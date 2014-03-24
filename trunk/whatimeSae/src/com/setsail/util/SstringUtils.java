/**
 * Created on 2013-12-4 下午1:42:33 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 作成日期： 2013-12-4 
 * <p>功能描述:    [所属模块及功能描述]</p>
 * @author: zhangyajie
 * @version 0.1
 */
public class SstringUtils extends StringUtils {

	public static String getNotNull(String src){
		return isEmpty(src) ? "" : src;
	}
	
	public static String getNotBlank(String src){
		return isBlank(src) ? "" : src;
	}
}
