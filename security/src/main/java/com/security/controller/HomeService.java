package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.security.domain.UserVO;

@Service
public class HomeService {
	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);

	@PreAuthorize("#userVO.user_name == authentication.name or hasRole(‘ROLE_ADMIN')")
	public void getUser(UserVO userVO) {
		logger.info("getUser success");
		System.out.println("작동안함????");
	}
}
