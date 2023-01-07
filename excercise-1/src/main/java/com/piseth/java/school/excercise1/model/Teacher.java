package com.piseth.java.school.excercise1.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person{
	private Subject subject;

	public Teacher(Long id, String name, Gender gender, LocalDate dob, Subject subject) {
		super(id, name, gender, dob);
		this.subject = subject;
	}  
	
	
}
