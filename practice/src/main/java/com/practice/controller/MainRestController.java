package com.practice.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class MainRestController {
	@Autowired
	private BookService bookService;

	// C
	@PostMapping("")
	public ResponseEntity<BookDto> createBooks(@RequestBody @Valid BookDto requestBook) {
		long startTime = System.currentTimeMillis();
		log.info("사용자 ''의 POST 요청 {}", requestBook.toString());
		BookDto createdBook = bookService.save(requestBook); // 요청 데이터 저장하고 값을 반환
		log.debug("사용자 ''의 POST 요청 소요시간 : {}", System.currentTimeMillis() - startTime);
		URI uri = URI.create("/books/" + createdBook.getId());
		return ResponseEntity.created(uri).body(createdBook);
	}

	// R
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> findBooks(@PathVariable("id") int id) {
		log.info("사용자 ''의 GET 요청 들어옴 id : {}", id);
		long startTime = System.currentTimeMillis();
		BookDto book = bookService.findById(id);
		log.debug("사용자 ''의 GET 요청 소요시간 : {}", System.currentTimeMillis() - startTime);
		return ResponseEntity.ok(book);
	}

	// U
	@PatchMapping("/{id}")
	public ResponseEntity<BookDto> patchBooks(@PathVariable("id") int id, @RequestBody BookDto requestBook) {
		log.info("사용자 ''의 PATCH 요청 {}", requestBook.toString());
		long startTime = System.currentTimeMillis();
		BookDto updated = bookService.update(id, requestBook);
		log.debug("사용자 ''의 PATCH 요청 소요시간 : {}", System.currentTimeMillis() - startTime);
		return ResponseEntity.ok(updated);
	}

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<BookDto> deleteBooks(@PathVariable("id") int id) {
		log.info("사용자 ''의 DELETE 요청 id : {}", id);
		long startTime = System.currentTimeMillis();
		bookService.delete(id);
		log.debug("사용자 ''의 DELETE 요청 소요시간 : {}", System.currentTimeMillis() - startTime);
		return ResponseEntity.ok().build();
	}

}
