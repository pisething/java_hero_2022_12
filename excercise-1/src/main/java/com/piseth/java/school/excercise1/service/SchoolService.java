package com.piseth.java.school.excercise1.service;

import java.util.List;
import java.util.Optional;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Teacher;

public interface SchoolService {
	Long getNumberOfTeachers(List<Teacher> teachers, Gender gender);

	Long getNumberOfStudents(List<ClassRoom> classRooms, int startYear, int grade, String className, Gender gender);
	
	Long getNumberOfStudents(List<ClassRoom> classRooms,int startYear, String teacherName);
	
	Long getNumberOfClassrooms(List<ClassRoom> classRooms,int startYear, String teacherName);
	
	Long getNumberOfPeople(List<ClassRoom> classRooms,int startYear);
	
	Optional<Teacher> findOldestTeacher(List<ClassRoom> classRooms,int startYear);
	
	List<Teacher> findTeacherByNumberOfStudent(List<ClassRoom> classRooms,int startYear, int numberOfStudent);
}
