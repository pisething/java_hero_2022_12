package com.piseth.java.school.excercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
}
