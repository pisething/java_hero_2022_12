package com.piseth.java.school.excercise2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // AOP - cross cut concern
public class AppExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handle(ApiException e) {
		JErrorResponse resp = new JErrorResponse(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(resp);
	}
}
