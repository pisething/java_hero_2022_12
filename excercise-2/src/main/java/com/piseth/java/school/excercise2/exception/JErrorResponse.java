package com.piseth.java.school.excercise2.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JErrorResponse {
	private final HttpStatus status;
	private final String message;
}
