package com.practice.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.BookDto;

@RestController
@RequestMapping("/books")
public class MainRestController {
	// C
	@PostMapping("")
	public ResponseEntity<BookDto> createBooks(@RequestBody BookDto book) {
		System.out.println("POST 요청");
		System.out.println(book.toString());
		return ResponseEntity.ok(book);
	}
	// R
	@GetMapping("/{id}")
	public String findBooks(@PathVariable("id") int id) {
		return "";
	}

	// U
	@PatchMapping("/{id}")
	public String patchBooks(@PathVariable("id") int id) {
		return "";
	}

	// D
	@DeleteMapping("/{id}")
	public String deleteBooks(@PathVariable("id") int id) {
		
		// delete 요청을 수행하는 로직
		return "";
	}
}
