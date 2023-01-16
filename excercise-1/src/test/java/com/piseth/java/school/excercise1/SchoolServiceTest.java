package com.piseth.java.school.excercise1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.piseth.java.school.excercise1.model.ClassRoom;
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
	public void testFindByNumberOfStudent() {

		List<ClassRoom> classRooms = SchoolHelper.getClassRooms();

		final List<Teacher> teacherByNumberOfStudent = schoolService.findTeacherByNumberOfStudent(classRooms, 2022, 100);

		assertEquals(0, teacherByNumberOfStudent.size());
	}


}


