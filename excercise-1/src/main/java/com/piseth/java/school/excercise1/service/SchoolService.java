package com.piseth.java.school.excercise1.service;

import java.util.List;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Sex;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Teacher;

public interface SchoolService {

	Long countTeacherBySex(Sex sex);

	Long countStudentByClassAndSex(int grade, String className, Sex sex);

	Long countStudentByTeacher(String tName);

	Long countClassByTeacherAndSchoolYear(String tName, int schoolYear);

	Long countAllStudentAndTeacher();

	Sex getSexOfEldestTeacher();

	List<Teacher> getTeachersWithStudentMoreThanN(int numberOfStudents);

	Classroom getClassWithMaxStudentBySex(Sex sex);

	Student getYoungestStudent();

	Long countClassByGrade(int i);

	Long countAllStudentBySchoolYear(int schoolYear);

	void initData();

}
