package com.spring.clubAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlayerExceptions {

	@ExceptionHandler
	public ResponseEntity<ExcptionsHandler> studentException(PlayerException e) {
		ExcptionsHandler exceptionHandler = new ExcptionsHandler();
		exceptionHandler.setStatusCode(HttpStatus.NOT_FOUND.value());
		exceptionHandler.setTime(System.currentTimeMillis());
		exceptionHandler.setMessage(e.getMessage());
		return new ResponseEntity<ExcptionsHandler>(exceptionHandler, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExcptionsHandler> studentException(Exception e) {
		ExcptionsHandler exceptionHandler = new ExcptionsHandler();
		exceptionHandler.setStatusCode(HttpStatus.BAD_REQUEST.value());
		exceptionHandler.setTime(System.currentTimeMillis());
		exceptionHandler.setMessage(e.getMessage());
		return new ResponseEntity<ExcptionsHandler>(exceptionHandler, HttpStatus.BAD_REQUEST);
	}
	
}
