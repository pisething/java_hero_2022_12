package com.piseth.java.school.excercise1.service;

import java.util.List;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Person;

public interface SchoolService {

	Long countTeacherByGender(Gender gender);

	Long countStudentByClassAndGender(int grade, String className, Gender gender);

	Long countStudentByTeacher(String tName);

	Long countClassByTeacherAndSchoolYear(String tName, int schoolYear);

	Long countAllStudentAndTeacher();

	Gender getGenderOfEldestTeacher();

	List<String> getTeachersWithStudentMoreThanN(int numberOfStudents);

	Classroom getClassWithMaxStudentByGender(Gender gender);

	Person getYoungestStudent();

	Long countClassByGrade(int i);

	Long countAllStudentBySchoolYear(int schoolYear);

	void initData();

}
