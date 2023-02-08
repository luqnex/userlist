package com.api.userlist.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.userlist.services.exceptions.IllegalArgumentException;

@ControllerAdvice
public class IllegalArgumentExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MessageResponseError> illegalArguments(IllegalArgumentException error) {
		
		MessageResponseError messageResponseError = new MessageResponseError();
		
		messageResponseError.setTimestamp(Instant.now());
		messageResponseError.setError("id_not_found");
		messageResponseError.setMessage(error.getMessage());
		messageResponseError.setStatus(HttpStatus.NOT_FOUND.value());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageResponseError);
		
	}
	
}
