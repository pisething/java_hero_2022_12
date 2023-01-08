package com.piseth.java.school.excercise1.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {
	private Subject subject;

	public Teacher(Subject subject, String name, Gender gender, LocalDate dateOfBirth) {
		super(name, gender, dateOfBirth);
		this.subject = subject;
	}
}
