package com.piseth.java.school.excercise1.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Classroom {
	private Long id;
	private int schoolYear; //ending year
	private int grade;
	private String name;
	private List<Teacher> teachers;
	private List<Student> students;
}
