package com.piseth.java.school.excercise2.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class ApiException extends RuntimeException {
	private final HttpStatus status;
	private final String message;
}
