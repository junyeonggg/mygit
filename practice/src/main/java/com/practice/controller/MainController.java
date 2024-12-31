package com.practice.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.dto.BookDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	// 홈 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}

	// Form Create 요청
	@PostMapping("/bookCForm")
	public String bookCForm(@ModelAttribute BookDto bookDto,@RequestHeader HttpHeaders headers, HttpServletRequest cookie,@CookieValue("sessionId") String sessionId) {
		System.out.println("폼 요청확인");
		System.out.printf("book : %s\n",bookDto.toString());
		System.out.println("headers : "+headers);
		System.out.println("headers2 : "+sessionId);
		System.out.println("cookie : " + cookie.getCookies());
		
		return "home";
	}
	//통합
	@ResponseBody
	@PostMapping("/bookC/{type}")
	public String bookCType(@PathVariable("type") String type,@RequestBody BookDto bookDto,@RequestHeader("Content-Type") String header1) {
		System.out.printf("%s 요청확인\n",type);
		System.out.printf("book : %s\n",bookDto.toString());
		System.out.println("header1:"+header1);
		return "";
	}
//20241230
}
