package com.piseth.java.school.excercise1.service;

import java.util.List;

import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Teacher;

public interface SchoolService {
	Long getNumberOfTeachers(List<Teacher> teachers, Gender gender);
}
