package com.setsail.web.android.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.response.SystemState;
import com.setsail.entity.user.User;
import com.setsail.service.user.UserService;
import com.setsail.web.android.annotation.Auth;

@Controller
@RequestMapping("/android/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@Auth
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String userName, String emailAddress, String password) {

		SystemState systemState = userService.login(userName, emailAddress, password);
		
		return JSON.toJSONString(systemState);
	}

	/**
	 * 用户注册 
	 * 
	 * @param user
	 * @return {“state”:0,”stateinfo”:”success”,”resinfo”:{“uuid”:”324243222”}}
	 * 
	 */
	@Auth
	@RequestMapping(value = "registUser", method = RequestMethod.POST)
	@ResponseBody
	public String registUser(String user) {
		
		User u = JSON.parseObject(user, User.class);
		SystemState us = userService.saveUser(u);
		
		return JSON.toJSONString(us);
	}

	/**
	 * 变更密码
	 * @param {“uuid”:”324243222”,”mime
	 * ”:”234738924793”,”oldPassword”:”E43AC43”,”newPassword”:”E43AC41”}
	 * @return {“state”:0,”stateinfo”:”success”}
	 * 
	 * */
	@RequestMapping(value = "uptPassword", method = RequestMethod.POST)
	@ResponseBody
	public String uptPassword(String userUuid, String mime, String oldPassword,
			String newPassword) {
		
		SystemState us = userService.updateUserPassword(userUuid, mime, oldPassword,
				newPassword);
		
		return JSON.toJSONString(us);
	}

	/**
	 * 完善用户信息 
	 * 
	 * @param user
	 * @return {“state”:0,”stateinfo”:”success”}
	 * 
	 * */
	@RequestMapping(value = "uptUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public String uptUserInfo(String userUuid, String mime,String user) {
		User u = JSON.parseObject(user, User.class);
		SystemState us = userService.updateUser(u);
		
		return JSON.toJSONString(us);

	}
	
	@RequestMapping(value = "getUser", method = RequestMethod.POST)
	@ResponseBody
	public String getUser(String userUuid, String mime,String uuid) {
		
		SystemState us = userService.findUserByUuid(uuid);
		
		return JSON.toJSONString(us);

	}

	@RequestMapping("ex")
	@ResponseBody
	public void test() throws Exception {
		throw new Exception();
	}
}
