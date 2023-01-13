package com.piseth.java.school.excercise1.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {
	public Student(Long id, String name, Gender gender, LocalDate birthDate) {
		super(id, name, gender, birthDate);
	}
}
