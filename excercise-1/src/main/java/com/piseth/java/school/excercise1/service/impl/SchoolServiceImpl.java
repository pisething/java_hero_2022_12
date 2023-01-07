package com.piseth.java.school.excercise1.service.impl;

import java.util.List;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.service.SchoolService;

public class SchoolServiceImpl implements SchoolService{

	@Override
	public Long getNumberOfTeachers(List<ClassRoom> classRooms, int startYear, Gender gender) {
		return classRooms.stream()
				.filter(cr -> cr.getStartYear() == startYear)
				.flatMap(cr -> cr.getTeachers().stream())
				.filter(t -> t.getGender() == gender)
				.distinct()
				.count();
	}

}
