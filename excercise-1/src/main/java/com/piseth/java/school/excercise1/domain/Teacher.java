package com.piseth.java.school.excercise1.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {
	private Subject subject;

	public Teacher(Long id, Subject subject, String name, Gender gender, LocalDate dateOfBirth) {
		super(id, name, gender, dateOfBirth);
		this.subject = subject;
	}
}
