package com.practice.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	private LocalDate publishedDate;
	
	private int price;

}
