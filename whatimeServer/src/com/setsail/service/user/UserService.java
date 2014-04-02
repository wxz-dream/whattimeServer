/**
 * Created on 2013-12-4 下午3:53:12 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.service.user;

import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.User;


/**
 * 作成日期： 2013-12-4 
 * <p>功能描述:    [所属模块及功能描述]</p>
 * @author: zhangyajie
 * @version 0.1
 */
public interface UserService {

	public abstract SystemState login(String userName, String email, String password);

	public abstract SystemState saveUser(User user);
	
	/**
	 *  更新用户信息，以下为客户端请求需要修改的字段
	 	uuid
	    mime
	    nickname
	    sex
	    userPhotouri
	    city
	    upttime
	    available
	    levelUuid
	    email
	    realName
	    telphone
	    identitycard
	    qq
	    authType
	 * @param user
	 * @return
	 */
	public abstract SystemState updateUser(User user);

	public abstract SystemState updateUserPassword(String uuid, String mime,
			String oldPassword, String newPassword);

	public abstract SystemState findUserByUuid(String uuid);

	public abstract SystemState findUserByUserName(String userName);
}