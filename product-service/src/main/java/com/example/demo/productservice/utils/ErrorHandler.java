package com.example.demo.productservice.utils;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorDetails handleAllException(Exception ex, WebRequest request) {
		
		return new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		
	}

}
