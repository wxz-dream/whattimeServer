/**
 * Created on 2013-12-4 下午1:24:04 
 * <p>描述:    [所属模块及功能描述]</p>
 * <p>版权所有： 有限责任公司</p>
 * @author: zhangyajie
 * @version 0.1
 */
package com.setsail.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.User;
import com.setsail.repository.user.UserRepository;
import com.setsail.service.user.UserService;
import com.setsail.util.SstringUtils;

/**
 * 作成日期： 2013-12-4
 * <p>
 * 功能描述: [用户相关操作处理]
 * </p>
 * 
 * @author: zhangyajie
 * @version 0.1
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * <p>
	 * 描述:[方法功能中文描述]
	 * </p>
	 * 
	 * @param userName
	 * @param email
	 * @param password
	 * @return
	 * @author: zhangyajie
	 * @update:
	 */

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState login(String userName, String email, String password) {

		User user = null;
		SystemState systemState = new SystemState();

		if (SstringUtils.isNotBlank(userName)) {
			user = userRepository.findByUserName(userName);
		}

		if (user == null && SstringUtils.isNotBlank(email)) {
			user = userRepository.findByEmail(email);
		}

		if (user != null
				&& SstringUtils.getNotBlank(password)
						.equals(user.getPassword())) {
			// 记录登陆时间
			user.setLoginTime(new Date().getTime());
			userRepository.saveAndFlush(user);
			// 设置成功状态
			systemState.setState(StateEnum.STATE_SUCCESS);
			user.setPassword(null); // 返回的用户信息不应带密码
			systemState.setResInfo(user);
			return systemState;
		}

		systemState.setState(StateEnum.STATE_FAIL);
		return systemState;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState saveUser(User user) {

		SystemState us = new SystemState(StateEnum.STATE_FAIL);
		if (user != null) {

			if (user.getUserName() != null
					&& userRepository.findByUserName(user.getUserName()) == null) {

				user.setLoginTime(new Date().getTime());
				user = userRepository.save(user);

				us.setState(StateEnum.STATE_SUCCESS);
				us.setResInfo(new User(user.getUuid()));
			}
		}

		return us;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState updateUser(User user) {

		User findUser = userRepository.findOne(user.getUuid());
		SystemState us = new SystemState();
		if (findUser == null) {
			// 保存的用户不存在，返回错误状态
			us.setState(StateEnum.STATE_FAIL);
		} else {
			// 更新用户信息
			user.setCreateTime(findUser.getCreateTime());
			user.setLoginTime(findUser.getLoginTime());
			user.setPassword(findUser.getPassword());
			user.setPhoneInfo(findUser.getPhoneInfo());
			user.setUserName(findUser.getUserName());
			userRepository.save(user);

			// 返回成功状态
			us.setState(StateEnum.STATE_SUCCESS);
		}

		return us;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public SystemState updateUserPassword(String uuid, String mime,
			String oldPassword, String newPassword) {

		User user = userRepository.findOne(uuid);

		SystemState us = new SystemState();

		if (user != null && user.getPassword() != null
				&& user.getPassword().equals(oldPassword)) {

			user.setMime(mime);
			user.setPassword(newPassword);
			userRepository.save(user);

			us.setState(StateEnum.STATE_SUCCESS);
			return us;
		}

		us.setState(StateEnum.STATE_FAIL);
		return us;
	}

	@Override
	public SystemState findUserByUuid(String uuid) {
		User user = userRepository.findOne(uuid);
		SystemState us = new SystemState();

		if (user != null) {
			user.setPassword("");
			us.setResInfo(user);
			us.setState(StateEnum.STATE_SUCCESS);
			return us;
		}

		us.setState(StateEnum.STATE_FAIL);
		return us;
	}

	@Override
	public SystemState findUserByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		SystemState us = new SystemState();

		if (user != null) {
			user.setPassword("");
			us.setResInfo(user);
			us.setState(StateEnum.STATE_SUCCESS);
			return us;
		}

		us.setState(StateEnum.STATE_FAIL);
		return us;
	}

	@Override
	public User findOne(String userId) {
		return userRepository.findOne(userId);
	}

	@Transactional(readOnly = false)
	public void save(User user) {
		userRepository.save(user);
	}

}
