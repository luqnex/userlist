package com.api.userlist.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.api.userlist.controllers")
public class NotfoundAdvice {

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> notFound(NotFoundException notFoundException) {
		MessageExceptionHandler error = new MessageExceptionHandler(
				new Date(), HttpStatus.NOT_FOUND.value(), "Not found"
		);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	 	
}
