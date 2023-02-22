package com.piseth.java.school.excercise2.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends ApiException {

	public ResourceNotFoundException(String resource, Long id) {
		super(HttpStatus.NOT_FOUND, String.format("%s with id %d is not found.", resource, id));
	}
}
