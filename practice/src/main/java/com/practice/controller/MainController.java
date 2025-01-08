package com.practice.controller;


import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.dto.BookDto;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {
	
	// 홈 이동
	@GetMapping("/")
	public String home(HttpServletResponse cookie) {
//		cookie.addCookie(new Cookie("testCookie","testCookie")); //쿠키를 저장하는 코드
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

	

//	//통합
//	@ResponseBody
//	@PostMapping("/books")
//	public ResponseEntity<BookDto> bookCType(@RequestBody BookDto bookDto) {
//		System.out.printf("book : %s\n",bookDto.toString());
//		// 성공적으로 생성되었을 때
//		return ResponseEntity.created(URI.create("/books/2")).body(bookDto);
//	}
//20241230
}
