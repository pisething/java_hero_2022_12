package com.piseth.java.school.excercise1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private String name;
	private Sex sex;
	private Integer age;
}
