package com.setsail.web.android.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.setsail.entity.ApkVersion;
import com.setsail.entity.response.StateEnum;
import com.setsail.entity.response.SystemState;
import com.setsail.repository.ApkVersionRepository;
import com.setsail.web.android.annotation.Auth;

@Controller
@RequestMapping("/android/")
public class ApkVersionController {
	
	@Autowired
	private ApkVersionRepository apkVersionRepository;

	@Auth
	@RequestMapping(value = "apkVersion")
	@ResponseBody
	public String getApkVersion() {
		
		SystemState ss = new SystemState(StateEnum.STATE_SUCCESS);
		
		Iterable<ApkVersion> apks = apkVersionRepository.findAll(
				new Sort(new Order(Direction.DESC, "version")));
		
		Iterator<ApkVersion> its = apks.iterator();
		ss.setResInfo(its.hasNext() ? its.next() : null);
		
		return JSON.toJSONString(ss);

	}
	
	@Auth
	@RequestMapping(value = "apk")
	public String getApk() {
		
		Iterable<ApkVersion> apks = apkVersionRepository.findAll(
				new Sort(new Order(Direction.DESC, "version")));
		
		Iterator<ApkVersion> its = apks.iterator();
		ApkVersion apk;
		if(its.hasNext()){ apk = its.next();
		
			return "redirect:" + apk.getUrl();
		}

		return "";
	}
	
	@Auth
	@RequestMapping(value = "saveApkVersion", method = RequestMethod.POST)
	@ResponseBody
	public String saveApkVersion(ApkVersion apk) {
		
		SystemState ss = new SystemState(StateEnum.STATE_SUCCESS);
		
		apkVersionRepository.save(apk);
		
		return JSON.toJSONString(ss);

	}
}
