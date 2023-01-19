package com.piseth.java.school.excercise1;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import java.util.Optional;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.piseth.java.school.excercise1.helper.SchoolHelper;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Teacher;
import com.piseth.java.school.excercise1.service.SchoolService;
import com.piseth.java.school.excercise1.service.impl.SchoolServiceImpl;

public class SchoolServiceTest {
	private SchoolService schoolService;
	
	@BeforeEach
	public void setup() {
		schoolService = new SchoolServiceImpl();
	}

	@Test
	public void testGetNumberOfTeacher() {
		//given
		List<Teacher> teachers = SchoolHelper.getTeachers();
		//when
		Long numberOfTeachers = schoolService.getNumberOfTeachers(teachers, Gender.MALE);
		
		//then
		assertEquals(4, numberOfTeachers);
	}

	@Test
	public  void testGetNumberOfStudentsInGrade12A() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		Long numberOfStudents = schoolService.getNumberOfStudents(classRooms, 2022, 12, "A", Gender.FEMALE);

		assertEquals(3, numberOfStudents);

	}

	@Test
	public void testGetNumberOfStudent() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		Long numberOfStudents = schoolService.getNumberOfStudents(classRooms, 2022, "Samnang");

		assertEquals(8, numberOfStudents);
	}

	@Test
	public void testGetNumberOfClassrooms() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		Long numberOfClassrooms = schoolService.getNumberOfClassrooms(classRooms, 2022, "Samnang");

		assertEquals(2, numberOfClassrooms);
	}

	@Test
	public void testGetNumberOfPeople() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		Long numberOfPeople = schoolService.getNumberOfPeople(classRooms, 2022);

		assertEquals(16, numberOfPeople);
	}

	@Test
	public void testFindOldestTeacher() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final Optional<Teacher> oldestTeacher = schoolService.findOldestTeacher(classRooms, 2022);

		assertTrue(oldestTeacher.isPresent());
		assertEquals("Piseth", oldestTeacher.get().getName());
	}

	@Test
	public void testFindTeacherByNumberOfStudent() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final List<Teacher> teacherByNumberOfStudent = schoolService.findTeacherByNumberOfStudent(classRooms, 2022, 100);

		assertEquals(0, teacherByNumberOfStudent.size());
	}

	@Test
	public void testFindClassRoomWhichHasTheMostStudentByGender() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final ClassRoom classRoomWhichHasTheMostStudentByGender = schoolService.findClassRoomWhichHasTheMostStudentByGender(classRooms, 2022, Gender.MALE);

		assertEquals("A", classRoomWhichHasTheMostStudentByGender.getName());

	}

	@Test
	public void testFindYoungestStudent() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final Optional<Student> youngestStudent = schoolService.findYoungestStudent(classRooms, 2022);

		assertTrue(youngestStudent.isPresent());
		assertEquals("Reaksmey", youngestStudent.get().getName());
	}

	@Test
	public void testGetNumberOfClassRoomByGrade() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final Long numberOfClassRoomByGrade = schoolService.getNumberOfClassRoomByGrade(classRooms, 2022, 12);

		assertEquals(2, numberOfClassRoomByGrade);

	}

	@Test
	public void testCompareNumberOfStudentByYearFail() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		assertThatThrownBy(() -> schoolService.compareNumberOfStudentByYear(classRooms, 2022, 2023))
				.isInstanceOf(RuntimeException.class).hasMessage("There is no classroom in year = 2023");

	}

	@Test
	public void testCompareNumberOfStudentByYearSuccess() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final int i = schoolService.compareNumberOfStudentByYear(classRooms, 2022, 2021);

		assertEquals(2, i);

	}

}


