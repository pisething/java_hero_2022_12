package com.piseth.java.school.excercise1.service.impl;

import java.util.List;

import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Teacher;
import com.piseth.java.school.excercise1.service.SchoolService;

public class SchoolServiceImpl implements SchoolService{

	@Override
	public Long getNumberOfTeachers(List<Teacher> teachers, Gender gender) {
		return teachers.stream()
				.filter(t -> t.getGender() == gender)
				.count();
	}

}
