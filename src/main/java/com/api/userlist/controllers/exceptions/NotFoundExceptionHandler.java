package com.api.userlist.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.userlist.services.exceptions.EntityNotFoundException;

@ControllerAdvice
public class NotFoundExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<MessageResponseError> notFound(EntityNotFoundException error) {
		
		MessageResponseError messageResponseError = new MessageResponseError();
		
		messageResponseError.setTimestamp(Instant.now());
		messageResponseError.setError("Not found entity");
		messageResponseError.setMessage(error.getMessage());
		messageResponseError.setStatus(HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageResponseError);
		
	}
	
}
