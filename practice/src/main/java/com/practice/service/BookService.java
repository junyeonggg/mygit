package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.BookDao;
import com.practice.dto.BookDto;
import com.practice.exception.BookNotFoundException;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	// 저장
	public BookDto save(BookDto book) {
		bookDao.save(book);
		return book;
	}

	// 읽기
	public BookDto findById(int id) {
		return bookDao.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found -> id : " + id));
	}

	// 업데이트
	public BookDto update(int id, BookDto reqeustBook) {
		bookDao.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found -> id : " + id)); // 코드 중복 나중에
		System.out.println(reqeustBook.toString());
		bookDao.update(id, reqeustBook);
		return findById(id);
	}

	public void delete(int id) {
		// id에 해당하는 book이 존재하는지 여부 확인
		bookDao.findById(id).orElseThrow(()-> new BookNotFoundException("Book Not Found -> id : " + id));
		bookDao.delete(id);
	}

}
