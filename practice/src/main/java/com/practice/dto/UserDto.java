package com.practice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDto {
	private int id;
	private String email;
	private String password;
	private String nickname;
	private String role;
}
