package com.piseth.java.school.excercise1.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Teacher {
	@NonNull
	private Subject subject;
	@NonNull
	private String name;
	@NonNull
	private Integer age;
	@NonNull
	private Sex sex;
	private int studentCount;
}
