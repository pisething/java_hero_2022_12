package com.piseth.java.school.excercise1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;

public class SchoolServiceImplTests {
	private SchoolServiceImpl schoolService = null;

	@Test
	public void testCountTeacherByGender() {
		assertEquals(3L, schoolService.countTeacherByGender(2023, Gender.MALE));
		assertEquals(5L, schoolService.countTeacherByGender(2023, Gender.FEMALE));
	}

	@Test
	public void testCountStudentByClassAndGender() {
		assertEquals(1, schoolService.countStudentByClassAndGender(2023, 12, "ក", Gender.FEMALE));
		assertEquals(2, schoolService.countStudentByClassAndGender(2023, 12, "ក", Gender.MALE));
	}

	@Test
	public void testCountStudentByTeacher() {
		assertEquals(21, schoolService.countStudentByTeacher(2023, "Samnang"));
		assertEquals(0, schoolService.countStudentByTeacher(2022, "Samnang"));
	}

	@Test
	public void testCountClassByTeacherAndSchoolYear() {
		assertEquals(5, schoolService.countClassByTeacherAndSchoolYear(2023, "Samnang"));
	}

	@Test
	public void testCountAllStudentAndTeacher() {
		assertEquals(51, schoolService.countAllStudentAndTeacher(2023));
	}

	@Test
	public void testGetGenderOfEldestTeacher() {
		assertEquals(Gender.MALE, schoolService.getGenderOfEldestTeacher(2023));
		assertNull(schoolService.getGenderOfEldestTeacher(2022));
	}

	@Test
	public void testGetTeachersWithStudentMoreThanN() {
		assertEquals(3, schoolService.getTeachersWithStudentMoreThanN(2023, 20).size());
		assertEquals(0, schoolService.getTeachersWithStudentMoreThanN(2023, 25).size());
	}

	@Test
	public void testGetClassWithMaxStudentByGender() {
		Classroom c = schoolService.getClassWithMaxStudentByGender(Gender.MALE);
		assertEquals("ក", c.getName());
		assertEquals(9, c.getGrade());
		assertEquals(2023, c.getSchoolYear());
	}

	@Test
	public void testGetYoungestStudent() {
		assertEquals("Danny", schoolService.getYoungestStudent().getName());
	}

	@Test
	public void testCountClassByGrade() {
		assertEquals( 2L, schoolService.countClassByGrade(12));
	}

	@Test
	public void testCountAllStudentBySchoolYear() {
		assertEquals(schoolService.countAllStudentBySchoolYear(2023), 43);
		assertEquals(schoolService.countAllStudentBySchoolYear(2022), 0);
	}
	
	@BeforeEach
	private void initTestData() {
		if (schoolService == null) {
			schoolService = new SchoolServiceImpl();
			schoolService.setMySchool(DataUtils.initData()); //TODO must have its own data for testing purpose.
		}
	}
}
