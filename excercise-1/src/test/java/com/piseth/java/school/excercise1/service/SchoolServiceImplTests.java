package com.piseth.java.school.excercise1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Sex;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Subject;
import com.piseth.java.school.excercise1.domain.Teacher;

public class SchoolServiceImplTests {
	private SchoolServiceImpl schoolService = null;

	@Test
	public void testCountTeacherBySex() {
		assertEquals(3L, schoolService.countTeacherBySex(Sex.MALE));
		assertEquals(5L, schoolService.countTeacherBySex(Sex.FEMALE));
	}

	@Test
	public void testCountStudentByClassAndSex() {
		assertEquals(1, schoolService.countStudentByClassAndSex(12, "ក", Sex.FEMALE));
		assertEquals(2, schoolService.countStudentByClassAndSex(12, "ក", Sex.MALE));
	}

	@Test
	public void testCountStudentByTeacher() {
		assertEquals(21, schoolService.countStudentByTeacher("Samnang"));
	}

	@Test
	public void testCountClassByTeacherAndSchoolYear() {
		assertEquals(5, schoolService.countClassByTeacherAndSchoolYear("Samnang", 2023));
	}

	@Test
	public void testCountAllStudentAndTeacher() {
		assertEquals(51, schoolService.countAllStudentAndTeacher());
	}

	@Test
	public void testGetSexOfEldestTeacher() {
		assertEquals(Sex.MALE, schoolService.getSexOfEldestTeacher());
	}

	@Test
	public void testGetTeachersWithStudentMoreThanN() {
		assertEquals(3, schoolService.getTeachersWithStudentMoreThanN(20).size());
		assertEquals(0, schoolService.getTeachersWithStudentMoreThanN(25).size());
	}

	@Test
	public void testGetClassWithMaxStudentBySex() {
		Classroom c = schoolService.getClassWithMaxStudentBySex(Sex.MALE);
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
	private void initSchoolService() {
		if (schoolService == null) {
			schoolService = new SchoolServiceImpl();

			// My school contain list of teachers, list of classes, list of students
			Teacher tSamnang = new Teacher(Subject.MATH, "Samnang", 33, Sex.MALE);
			Teacher tVeasna = new Teacher(Subject.MATH, "Veasna", 29, Sex.FEMALE);
			Teacher tSoksan = new Teacher(Subject.PHYSICS, "Soksan", 40, Sex.FEMALE);
			Teacher tMakara = new Teacher(Subject.PHYSICS, "Makara", 41, Sex.FEMALE);
			Teacher tKunthea = new Teacher(Subject.KHMER, "Kunthea", 27, Sex.FEMALE);
			Teacher tSovath = new Teacher(Subject.KHMER, "Sovath", 33, Sex.MALE);
			Teacher tSeyha = new Teacher(Subject.KHMER, "Seyha", 49, Sex.MALE);
			Teacher tChenda = new Teacher(Subject.KHMER, "Chenda", 46, Sex.FEMALE);
			
			// Class ១២ក
			Student sDara = new Student("Dara", Sex.MALE, 18);
			Student sRy = new Student("Ry", Sex.FEMALE, 18);
			Student sSok = new Student("Sok", Sex.MALE, 18);
			// Class ១២ខ
			Student sNary = new Student("Nary", Sex.FEMALE, 18);
			Student sDom = new Student("Dom", Sex.MALE, 18);
			Student sLeang = new Student("Leang", Sex.FEMALE, 19);
			Student sKong = new Student("Kong", Sex.MALE, 18);
			Student sChan = new Student("Chan", Sex.FEMALE, 17);
			// Class ១១ក
			Student sDalin = new Student("Dalin", Sex.FEMALE, 17);
			Student sKompheak = new Student("Kompheak", Sex.MALE, 17);
			Student sPheak = new Student("Pheak", Sex.MALE, 17);
			Student sKdey = new Student("Kdey", Sex.FEMALE, 17);
			// Class ១១ខ
			Student sPheatra = new Student("Pheaktra", Sex.MALE, 17);
			Student sTra = new Student("Tra", Sex.MALE, 17);
			Student sChetra = new Student("Chetra", Sex.MALE, 17);
			// Class 10ក
			Student sCheata = new Student("Cheata", Sex.FEMALE, 16);
			Student sSocheat = new Student("Socheat", Sex.MALE, 16);
			Student sSam = new Student("Sam", Sex.MALE, 16);
			Student sCheng = new Student("Cheng", Sex.FEMALE, 16);
			Student sMealea = new Student("Mealea", Sex.FEMALE, 16);
			// Class ១០ខ
			Student sSochea = new Student("Sochea", Sex.FEMALE, 16);
			Student sReaksa = new Student("Reaksa", Sex.FEMALE, 16);
			Student sRangsey = new Student("Rangsey", Sex.FEMALE, 16);
			Student sPisey = new Student("Pisey", Sex.FEMALE, 16);
			Student sSomnang = new Student("Somnang", Sex.MALE, 16);
			Student sSan = new Student("San", Sex.MALE, 16);
			// Class ៩ក
			Student sMom = new Student("sMom", Sex.FEMALE, 15);
			Student sSrey = new Student("Srey", Sex.FEMALE, 15);
			Student sKakada = new Student("Kakada", Sex.MALE, 15);
			Student sVichet = new Student("Vichet", Sex.MALE, 14);
			Student sMeng = new Student("Meng", Sex.MALE, 13);
			Student sSensok = new Student("Sensok", Sex.MALE, 13);
			// Class ៩ខ
			Student sKa = new Student("Ka", Sex.FEMALE, 14);
			Student sSnar = new Student("Snar", Sex.MALE, 14);
			Student sSmey = new Student("Smey", Sex.FEMALE, 14);
			Student sVorak = new Student("Vorak", Sex.MALE, 14);
			// Class ៩គ
			Student sRina = new Student("Rina", Sex.FEMALE, 13);
			Student sPhally = new Student("Phally", Sex.FEMALE, 13);
			Student sPhanna = new Student("Phanna", Sex.FEMALE, 13);
			Student sSophea = new Student("Sophea", Sex.MALE, 13);
			Student sSorphea = new Student("Sorphea", Sex.FEMALE, 13);
			Student sDalis = new Student("Dalis", Sex.FEMALE, 13);
			Student sDanny = new Student("Danny", Sex.FEMALE, 12);
			
			List<Classroom> mySchool = List.of(//
					new Classroom(2023, 12, "ក", List.of(tSamnang, tSoksan, tChenda), List.of(sDara, sRy, sSok)),
					new Classroom(2023, 12, "ខ", List.of(tVeasna, tSoksan, tSeyha),
							List.of(sNary, sDom, sLeang, sKong, sChan)),
					new Classroom(2023, 11, "ក", List.of(tSamnang, tMakara, tKunthea),
							List.of(sDalin, sKompheak, sPheak, sKdey)),
					new Classroom(2023, 11, "ខ", List.of(tSamnang, tMakara, tChenda), List.of(sPheatra, sTra, sChetra)),
					new Classroom(2023, 10, "ក", List.of(tSamnang, tSoksan, tSeyha),
							List.of(sCheata, sSocheat, sSam, sCheng, sMealea)),
					new Classroom(2023, 10, "ខ", List.of(tSamnang, tSoksan, tSovath),
							List.of(sSochea, sReaksa, sRangsey, sPisey, sSomnang, sSan)),
					new Classroom(2023, 9, "ក", List.of(tVeasna, tMakara, tSovath),
							List.of(sMom, sSrey, sKakada, sVichet, sMeng, sSensok)),
					new Classroom(2023, 9, "ខ", List.of(tVeasna, tMakara, tSovath), List.of(sKa, sSnar, sSmey, sVorak)),
					new Classroom(2023, 9, "គ", List.of(tVeasna, tMakara, tKunthea),
							List.of(sRina, sPhally, sPhanna, sSophea, sSorphea, sDalis, sDanny)));
			schoolService.setMySchool(mySchool);
		}
	}
}
