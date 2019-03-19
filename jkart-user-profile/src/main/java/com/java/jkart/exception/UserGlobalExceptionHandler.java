package com.java.jkart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> userNotFOund(UserNotFoundException unfExp) {
		return new ResponseEntity<>("User Not FOund", HttpStatus.NOT_FOUND);
	}
}
