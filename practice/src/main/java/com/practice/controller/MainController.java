package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.dto.BookDto;

@Controller
public class MainController {
	
	// 홈 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}

	// Form Create 요청
	@PostMapping("/bookCForm")
	public String bookCForm() {
		System.out.println("폼 요청확인");
		return "home";
	}
	//통합
	@ResponseBody
	@PostMapping("/bookC/{type}")
	public String bookCType(@PathVariable("type") String type,@RequestBody BookDto bookDto) {
		System.out.printf("%s 요청확인\n",type);
		System.out.printf("book : %s\n",bookDto.toString());
		return "";
	}

}
