package com.piseth.java.school.excercise1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {
	private Long id;
	private String name;
	private Integer grade;
	private Integer startYear;
	private List<Teacher> teachers;
	private List<Student> students;
}
