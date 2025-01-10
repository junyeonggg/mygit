package com.practice.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
public class BookDto {
	
	private int id;
	
	@NotEmpty 
	private String title;
	
	@NotEmpty
	private String author;
	
	@PastOrPresent
	@NotNull
	private LocalDate publishedDate;
	
	@Positive
	private Integer price;

}
