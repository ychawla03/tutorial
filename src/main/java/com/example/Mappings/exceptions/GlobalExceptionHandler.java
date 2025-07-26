package com.example.Mappings.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleEmailAdreadyExistException
	(EmailAlreadyExistException ex, 
			WebRequest wb) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), ex.getMessage(),
				wb.getDescription(true), "USER_EMAIL_ALREADY_EXIST");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException
	(ResourceNotFoundException ex, 
			WebRequest wb) {
		
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), ex.getMessage(),
				wb.getDescription(false), "USER_NOT_FOUND");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
