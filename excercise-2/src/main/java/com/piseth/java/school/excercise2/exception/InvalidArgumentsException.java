package com.piseth.java.school.excercise2.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class InvalidArgumentsException extends ApiException {

	public InvalidArgumentsException(String arg, String val) {
		super(HttpStatus.BAD_REQUEST, String.format("Bad parameter value (%s:%s)", arg, val));
	}
}
