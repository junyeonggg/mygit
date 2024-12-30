package com.practice.dto;

import java.time.LocalDate;

public class BookDto {
	private String title;
	private String author;
	private LocalDate publishedDate;
	private int price;

	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookDto("+"title:"+title+ ",author:"+author+",publishedDate:"+publishedDate.toString()+
				",price:"+price+")";
	}
}
