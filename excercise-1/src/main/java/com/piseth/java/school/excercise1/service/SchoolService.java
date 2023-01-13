package com.piseth.java.school.excercise1.service;

import java.util.List;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Student;

public interface SchoolService {

	Long countTeacherByGender(int schoolYear, Gender gender);

	Long countStudentByClassAndGender(int schoolYear, int grade, String className, Gender gender);

	Long countStudentByTeacher(int schoolYear, String tName);

	Long countClassByTeacherAndSchoolYear(int schoolYear, String tName);

	Long countAllStudentAndTeacher(int schoolYear);

	Gender getGenderOfEldestTeacher(int schoolYear);

	List<String> getTeachersWithStudentMoreThanN(int schoolYear, int numberOfStudents);

	Classroom getClassWithMaxStudentByGender(Gender gender);

	Student getYoungestStudent();

	Long countClassByGrade(int i);

	Long countAllStudentBySchoolYear(int schoolYear);

	void initData();

}
