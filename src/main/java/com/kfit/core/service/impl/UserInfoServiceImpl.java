package com.kfit.core.service.impl;

import com.kfit.core.bean.UserInfo;
import com.kfit.core.repository.UserInfoRepository;
import com.kfit.core.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Resource
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfo findByUsername(String username) {
		return userInfoRepository.findByUsername(username);
	}
	
}
