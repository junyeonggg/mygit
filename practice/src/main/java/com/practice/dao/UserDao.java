package com.practice.dao;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.practice.dto.UserDto;

@Mapper
public interface UserDao {
	void create(UserDto user);

	Optional<UserDto> checkUser(UserDto user);
}
