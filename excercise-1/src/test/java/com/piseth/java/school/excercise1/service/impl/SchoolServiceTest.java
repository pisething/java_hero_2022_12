package com.piseth.java.school.excercise1.service.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.piseth.java.school.excercise1.helper.SchoolHelper;
import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Student;
import com.piseth.java.school.excercise1.model.Teacher;

public class SchoolServiceTest {
	private SchoolServiceImpl schoolService;

	@BeforeEach
	public void setup() {
		schoolService = new SchoolServiceImpl();
	}

	@Test
	public void testGetNumberOfTeacher() {
		// given
		List<Teacher> teachers = SchoolHelper.getTeachers();
		// when
		Long numberOfTeachers = schoolService.getNumberOfTeachers(teachers, Gender.MALE);
		// then
		assertEquals(4, numberOfTeachers);
	}

	@Test
	public void testGetNumberOfStudentsOfTeacher() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Long numberOfStudents = schoolService.getNumberOfStudents(classrooms, 2022, "Samnang");
		// then
		assertEquals(8, numberOfStudents);
	}

	@Test
	public void testGetNumberOfStudents() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Long numberOfStudents = schoolService.getNumberOfStudents(classrooms, 2022, 12, "A", Gender.FEMALE);
		// then
		assertEquals(3, numberOfStudents);
	}

	@Test
	public void testGetNumberOfClassrooms() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Long numberOfClassrooms = schoolService.getNumberOfClassrooms(classrooms, 2022, "Samnang");
		// then
		assertEquals(2, numberOfClassrooms);
	}

	@Test
	public void testGetTeacher() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		// then
		assertThatThrownBy(() -> schoolService.getNumberOfClassrooms(classrooms, 2020, "Samnang"))
				.isInstanceOf(RuntimeException.class)
				.hasMessage(String.format("There is no teacher with name = Samnang"));

	}

	@Test
	public void testGetNumberOfPeople() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Long totalCount = schoolService.getNumberOfPeople(classrooms, 2022);
		// then
		assertEquals(16, totalCount);
	}

	@Test
	public void testFindOldestTeacher() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Optional<Teacher> oldestTeacher = schoolService.findOldestTeacher(classrooms, 2022);
		// then
		assertTrue(oldestTeacher.isPresent());
	}

	@Test
	public void testFindOldestTeacherEmpty() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Optional<Teacher> oldestTeacher = schoolService.findOldestTeacher(classrooms, 2019);
		// then
		assertTrue(oldestTeacher.isEmpty());
	}

	@Test
	public void testFindTeacherByNumberOfStudent() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		List<Teacher> teachers = schoolService.findTeacherByNumberOfStudent(classrooms, 2022, 3);
		// then
		assertEquals(4, teachers.size());
	}

	@Test
	public void testFindClassRoomWhichHasTheMostStudentByGender() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		ClassRoom maxMaleClassroom = schoolService.findClassRoomWhichHasTheMostStudentByGender(classrooms, 2022,
				Gender.MALE);
		// then
		assertEquals("B", maxMaleClassroom.getName());
	}

	@Test
	public void testFindYoungestStudent() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Optional<Student> student = schoolService.findYoungestStudent(classrooms, 2022);
		// then
		assertTrue(student.isPresent());
		assertEquals("Reaksmey", student.get().getName());
	}

	@Test
	public void testGetNumberOfClassRoomByGrade() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		Long n = schoolService.getNumberOfClassRoomByGrade(classrooms, 2022, 11);
		// then
		assertEquals(1, n);
	}

	@Test
	public void testCompareNumberOfStudentByYearThrow() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		// assert
		assertThatThrownBy(() -> schoolService.compareNumberOfStudentByYear(classrooms, 2023, 2020))
				.isInstanceOf(RuntimeException.class).hasMessage(String.format("There is no classroom in year = 2023"));
	}

	@Test
	public void testCompareNumberOfStudentByYear() {
		// given
		List<ClassRoom> classrooms = SchoolHelper.getClassRooms();
		// when
		int c = schoolService.compareNumberOfStudentByYear(classrooms, 2021, 2022);
		// assert
		assertTrue(c < 0);
	}
}
