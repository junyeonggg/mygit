package com.practice.controller;

import java.util.Enumeration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dto.UserDto;
import com.practice.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	private UserService userService;
	// 홈 이동
	@GetMapping("/")
	public String home(HttpSession session) {
//		cookie.addCookie(new Cookie("testCookie","testCookie")); //쿠키를 저장하는 코드
		// 쿠키 확인 코드
//		Enumeration<String> attributeNames = session.getAttributeNames();
//
//		while (session.getAttributeNames().hasMoreElements()) {
//			String key = attributeNames.nextElement();
//			Object value = session.getAttribute(key);
//			System.out.print("key : "+key);
//			System.out.println(" value : "+value);
//		}
		return "home";
	}



	// Form Create 요청
	// 헤더와 쿠키
//	@PostMapping("/bookCForm")
//	public String bookCForm(@ModelAttribute BookDto bookDto,@RequestHeader HttpHeaders headers, HttpServletRequest cookie,@CookieValue("testCookie") String sessionId) {
//		System.out.println("폼 요청확인");
//		System.out.printf("book : %s\n",bookDto.toString());
//		System.out.println("headers : "+headers);
//		System.out.println("headers2 : "+sessionId);
//		System.out.println("cookie : " + cookie.getCookies());
//		
//		
//		return "home";
//	}
}
