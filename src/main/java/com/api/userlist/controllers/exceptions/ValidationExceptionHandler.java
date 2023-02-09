package com.api.userlist.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.userlist.services.exceptions.ValidationException;


@ControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<MessageResponseError> notFound(ValidationException error) {
		
		MessageResponseError messageResponseError = new MessageResponseError();
		
		messageResponseError.setTimestamp(Instant.now());
		messageResponseError.setError("bad_request");
		messageResponseError.setMessage(error.getMessage());
		messageResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageResponseError);
		
	}
	
}
