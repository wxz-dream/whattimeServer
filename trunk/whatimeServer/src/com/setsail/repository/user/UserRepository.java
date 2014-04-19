/**
 * Created on 2013-12-4 下午12:36:25 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.user.User;

/**
 * 作成日期： 2013-12-4 
 * <p>功能描述:    [所属模块及功能描述]</p>
 * @author: zhangyajie
 * @version 0.1
 */
public interface UserRepository extends JpaRepository<User, String>{

	public User findByUserName(String userName);

	public User findByEmail(String email);
	
	public User findUserNameByEmail(String email);

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	@Override
	public User save(User user);
	
}
