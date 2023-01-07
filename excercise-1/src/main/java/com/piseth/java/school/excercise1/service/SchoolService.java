package com.piseth.java.school.excercise1.service;

import java.util.List;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;

public interface SchoolService {
	Long getNumberOfTeachers(List<ClassRoom> classRooms, int startYear, Gender gender);
}
