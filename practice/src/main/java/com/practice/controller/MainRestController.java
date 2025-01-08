package com.practice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		System.out.println(requestBook.toString());
		try {
			BookDto book = bookService.save(requestBook);
			URI uri = URI.create("/books/2");// +book.getId()); // 생성된 리소스 URI
			return ResponseEntity.created(uri).body(requestBook);

		} catch (Exception e) { // 이외의 에러
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(requestBook);
		}
	}

	// R
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> findBooks(@PathVariable("id") int id) {
		System.out.println("GET 요청");
		BookDto book = bookService.findById(id);
		return ResponseEntity.ok(book);
//		try {
//			BookDto book = mainService.getBookById(id);
//			if(book == null) {
//				return ResponseEntity.noContent().build();
//			}else {
//				return ResponseEntity.ok(book);
//			}
//			
//		} catch (Exception e) { // db - controller 간의 에러
//			e.printStackTrace();
//			return ResponseEntity.badRequest().build();
//		}
	}

	// U
	@PatchMapping("/{id}")
	public ResponseEntity<BookDto> patchBooks(@PathVariable("id") int id, @RequestBody BookDto reqeustBook) {
		System.out.println("Patch 요청");
		try {
			BookDto book = bookService.update(reqeustBook);
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	// D
	@DeleteMapping("/{id}")
	public ResponseEntity<BookDto> deleteBooks(@PathVariable("id") int id) {
		try {
			bookService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
