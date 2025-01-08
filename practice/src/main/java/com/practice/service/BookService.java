package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.dao.BookDao;
import com.practice.dto.BookDto;
import com.practice.exception.BookNotFoundException;

@Service
public class BookService {
	private BookDao bookDao = new BookDao();

	// 저장
	public BookDto save(BookDto book) {
		return book;
	}

	// 읽기
	public BookDto findById(int id) {
		return bookDao.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book Not Found -> id : " + id));
	}

	// 업데이트
	public BookDto update(BookDto reqeustBook) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
