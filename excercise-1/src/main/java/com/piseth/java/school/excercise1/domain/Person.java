package com.piseth.java.school.excercise1.domain;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private Long id;
	private String name;
	private Gender gender;
	private LocalDate birthDate;

	public int getAge() {
		if (birthDate != null) {
			LocalDate now = LocalDate.now();
			return Period.between(birthDate, now).getYears();
		} else {
			return -1;
		}
	}
}
