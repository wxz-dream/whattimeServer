/**
 * Created on 2013-12-4 下午12:36:25 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.repository.user;

import com.setsail.entity.user.User;
import com.setsail.repository.BaseRepository;

/**
 * 作成日期： 2013-12-4 
 * <p>功能描述:    [所属模块及功能描述]</p>
 * @author: zhangyajie
 * @version 0.1
 */
public interface UserRepository extends BaseRepository<User, String>{
	
	public User findByUserName(String userName);

	public User findByEmail(String email);

}
