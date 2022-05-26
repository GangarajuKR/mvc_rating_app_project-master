package com.ty.Rating_app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerId {
	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<String> handleNoIdFoundException(NoIdFoundException idFoundException) {
		String message = idFoundException.getMessage();
		ResponseEntity<String> entity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		return entity;
	}
}
