package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.UserDao;
import com.practice.dto.UserDto;
import com.practice.exception.UserNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void create(UserDto user) {
		userDao.create(user);
	}

	public UserDto checkUser(UserDto user) {
		// 일치하는 정보가 있는지 확인
		return userDao.checkUser(user).orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다."));
	}

}
