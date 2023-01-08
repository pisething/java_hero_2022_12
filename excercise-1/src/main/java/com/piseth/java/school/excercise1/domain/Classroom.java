package com.piseth.java.school.excercise1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Classroom {
	private int schoolYear;
	private int grade;
	private String name;
	private List<Teacher> teachers;
	private List<Person> students;
}
