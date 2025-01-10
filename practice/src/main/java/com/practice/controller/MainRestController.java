package com.practice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.practice.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class MainRestController {
	@Autowired
	private BookService bookService;

	// C
	@PostMapping("")
	public ResponseEntity<BookDto> createBooks(@RequestBody @Valid BookDto requestBook) {
		System.out.println("POST 요청");
		System.out.println(requestBook.toString()); // 요청 데이터 확인
		BookDto createdBook = bookService.save(requestBook); // 요청 데이터 저장하고 값을 반환
		URI uri = URI.create("/books/" + createdBook.getId());
		System.out.println("저장 완료");
		return ResponseEntity.created(uri).body(createdBook);
	}

	// R
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> findBooks(@PathVariable("id") int id) {
		System.out.println("GET 요청");
		BookDto book = bookService.findById(id);
		return ResponseEntity.ok(book);
	}

	// U
	@PatchMapping("/{id}")
	public ResponseEntity<BookDto> patchBooks(@PathVariable("id") int id, @RequestBody BookDto reqeustBook) {
		System.out.println("Patch 요청");
		BookDto updated = bookService.update(id, reqeustBook);
		return ResponseEntity.ok(updated);
	}

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<BookDto> deleteBooks(@PathVariable("id") int id) {
		bookService.delete(id);
		return ResponseEntity.ok().build();
	}

}
