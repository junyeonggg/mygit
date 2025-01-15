package com.practice.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practice.dto.ErrorDto;
import com.practice.dto.UserDto;
import com.practice.dto.ValidationErrorDto;
import com.practice.exception.BookNotFoundException;
import com.practice.exception.UserNotFoundException;

import jakarta.servlet.http.HttpSession;

@RestControllerAdvice
public class GlobalExceptionHandler {
	// 모델 전역처리
	@ModelAttribute("Authenticated")
	public UserDto user(HttpSession session) {
		return (UserDto) session.getAttribute("Authenticated");
	}
	
	// UserNotFoundException
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDto> handleUserNotFoundException(UserNotFoundException ex){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorDto(ex.getMessage()));
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorDto> handleBookNotFoundException(BookNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(ex.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ValidationErrorDto> validationErrors = fieldErrors.stream()
				.map((fieldError) -> new ValidationErrorDto(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
		return ResponseEntity.badRequest().body(new ErrorDto("데이터 형식을 확인해 주세요."));
	}
}
