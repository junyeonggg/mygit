package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.dto.UserDto;
import com.practice.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/auth")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	// 회원가입 페이지
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	// 로그인 페이지
	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	// 회원가입
	@PostMapping("/signup")
	public String signup(@RequestBody UserDto user){
		userService.create(user);
		return "home";
	}
	
	// 로그인
	@PostMapping("/signin")
	public String signin(@RequestBody UserDto requestuser,HttpServletRequest request,  HttpSession session){
		// service로 넘김
		session.invalidate();
		UserDto user = userService.checkUser(requestuser);
		HttpSession newSession = request.getSession();
		newSession.setAttribute("Authenticated", user);
		log.info("{}님이 로그인 하였습니다.",user.getEmail());
		return "home";
	}
	@PostMapping("/signout")
	public String signout(HttpSession session){
		// service로 넘김
		UserDto user = (UserDto) session.getAttribute("Authenticated");
		session.invalidate();
		log.info("{}님이 로그아웃 하였습니다.",user.getEmail());
		return "home";
	}

}
