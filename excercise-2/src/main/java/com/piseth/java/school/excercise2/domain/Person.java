package com.piseth.java.school.excercise2.domain;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Person extends AbstractEntity {
	private String name;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate dob;
}
