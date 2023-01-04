package com.piseth.java.school.excercise1.domain;

import java.util.List;

import lombok.Data;

@Data
public class Classroom {
	private int schoolYear;
	private int grade;
	private String name;
	private List<Teacher> teachers;
	private List<Student> students;

	public Classroom(int schoolYear, int grade, String name, List<Teacher> teachers, List<Student> students) {
		super();
		this.schoolYear = schoolYear;
		this.grade = grade;
		this.name = name;
		this.teachers = teachers;
		this.students = students;
		
		this.teachers.forEach(t -> {
				t.setStudentCount(t.getStudentCount() + students.size());
			});
	}
}
