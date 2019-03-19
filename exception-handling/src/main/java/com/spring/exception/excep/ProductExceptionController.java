package com.spring.exception.excep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	
	@ExceptionHandler(value=ProductNotfoundException.class)
	public ResponseEntity<Object> exception(ProductNotfoundException excep) {
		return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
	}
}
