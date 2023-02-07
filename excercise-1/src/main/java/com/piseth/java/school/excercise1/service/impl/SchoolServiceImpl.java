package com.piseth.java.school.excercise1.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Student;
import com.piseth.java.school.excercise1.model.Teacher;
import com.piseth.java.school.excercise1.service.SchoolService;

public class SchoolServiceImpl implements SchoolService{

	@Override
	public Long getNumberOfTeachers(List<Teacher> teachers, Gender gender) {
		return teachers.stream()
				.filter(t -> t.getGender() == gender)
				.count();
	}

	@Override
	public Long getNumberOfStudents(List<ClassRoom> classRooms, int startYear, int grade, String className, Gender gender) {
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.filter(cr -> cr.getGrade() == grade)
		.filter(cr -> cr.getName().equals(className))
		.flatMap(cr -> cr.getStudents().stream())
		.filter(st -> st.getGender() == gender)
		.count();
	}

	@Override
	public Long getNumberOfStudents(List<ClassRoom> classRooms, int startYear, String teacherName) {
		Teacher teacher = getTeacher(classRooms, startYear, teacherName);
		
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.filter(cr -> cr.getTeachers().contains(teacher))
		.flatMap(cr -> cr.getStudents().stream())
		.count();
				
	}

	@Override
	public Long getNumberOfClassrooms(List<ClassRoom> classRooms, int startYear, String teacherName) {
		Teacher teacher = getTeacher(classRooms, startYear, teacherName);
		
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.filter(cr -> cr.getTeachers().contains(teacher))
		.count();
	}
	
	private Teacher getTeacher(List<ClassRoom> classRooms, int startYear, String teacherName) {
		Teacher teacher = classRooms.stream()
				.filter(cr -> cr.getStartYear() == startYear)
				.flatMap(cr -> cr.getTeachers().stream())
				.filter(t -> t.getName().equals(teacherName))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("There is no teacher with name = %s".formatted(teacherName)));
		return teacher;
	}

	@Override
	public Long getNumberOfPeople(List<ClassRoom> classRooms, int startYear) {
		return classRooms.stream()
				.filter(cr -> cr.getStartYear() == startYear)
				.mapToLong(cr -> cr.getTeachers().size() + cr.getStudents().size())
				.sum();
	}

	@Override
	public Optional<Teacher> findOldestTeacher(List<ClassRoom> classRooms, int startYear) {
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.flatMap(cr -> cr.getTeachers().stream())
		.max((t1,t2) -> t1.getDob().compareTo(t2.getDob()));
	}

	@Override
	public List<Teacher> findTeacherByNumberOfStudent(List<ClassRoom> classRooms, int startYear, int numberOfStudent) {
		// this is filtered by number of student per class & year, while I think, we should filter by year of combine class of each teacher
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.filter(cr -> cr.getStudents().size() > numberOfStudent)
		.flatMap(cr -> cr.getTeachers().stream())
		.toList();
	}

	@Override
	public ClassRoom findClassRoomWhichHasTheMostStudentByGender(List<ClassRoom> classRooms, int startYear,
			Gender gender) {
		return classRooms.stream()
			.filter(cr -> cr.getStartYear() == startYear)
			.collect(Collectors.toMap(Function.identity(),  
					cr -> cr.getStudents().stream().filter(st -> st.getGender() == gender).count()))
			.entrySet()
			.stream()
			.max((a,b) -> a.getValue().compareTo(b.getValue()))
			.get()
			.getKey();
	}

	@Override
	public Optional<Student> findYoungestStudent(List<ClassRoom> classRooms, int startYear) {
		return classRooms.stream()
				.filter(cr -> cr.getStartYear() == startYear)
				.flatMap(cr -> cr.getStudents().stream())
				.min((t1,t2) -> t1.getDob().compareTo(t2.getDob()));
	}

	@Override
	public Long getNumberOfClassRoomByGrade(List<ClassRoom> classRooms, int startYear, int grade) {
		return classRooms.stream()
		.filter(cr -> cr.getStartYear() == startYear)
		.filter(cr -> cr.getGrade() == grade)
		.count();
	}
	
	private void validateYear(List<ClassRoom> classRooms, int year) {
		classRooms.stream()
		.filter(cr -> cr.getStartYear() == year)
		.findAny()
		.orElseThrow(() -> new RuntimeException("There is no classroom in year = %d".formatted(year)));
	}

	@Override
	public int compareNumberOfStudentByYear(List<ClassRoom> classRooms, int year1, int year2) {
		validateYear(classRooms, year1);
		validateYear(classRooms, year2);
		
		Map<Integer, Long> mapClassRoom = classRooms.stream()
				.filter(cr -> cr.getStartYear() == year1 || cr.getStartYear() == year2)
				.collect(Collectors.groupingBy(ClassRoom::getStartYear, Collectors.counting()));
		return (int) (mapClassRoom.get(year1) - mapClassRoom.get(year2)); 
	}

}
