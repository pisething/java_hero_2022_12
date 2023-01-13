package com.piseth.java.school.excercise1.service;

import java.time.LocalDate;
import java.util.List;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Subject;
import com.piseth.java.school.excercise1.domain.Teacher;

public class DataUtils {

	public static List<Classroom> initData() {
		Subject math = new Subject(1L, "Math");
		Subject physics = new Subject(2L, "Physics");
		Subject khmer = new Subject(3L, "Khmer");

		// My school contain list of teachers, list of classes, list of students
		Teacher tSamnang = new Teacher(1L, math, "Samnang", Gender.MALE, LocalDate.of(1990, 10, 20));
		Teacher tVeasna = new Teacher(2L, math, "Veasna", Gender.FEMALE, LocalDate.of(1994, 10, 20));
		Teacher tSoksan = new Teacher(3L, physics, "Soksan", Gender.FEMALE, LocalDate.of(1983, 10, 20));
		Teacher tMakara = new Teacher(4l, physics, "Makara", Gender.FEMALE, LocalDate.of(1982, 10, 20));
		Teacher tKunthea = new Teacher(5l, khmer, "Kunthea", Gender.FEMALE, LocalDate.of(1996, 10, 20));
		Teacher tSovath = new Teacher(6l, khmer, "Sovath", Gender.MALE, LocalDate.of(1990, 10, 20));
		Teacher tSeyha = new Teacher(7l, khmer, "Seyha", Gender.MALE, LocalDate.of(1974, 10, 20));
		Teacher tChenda = new Teacher(8l, khmer, "Chenda", Gender.FEMALE, LocalDate.of(1977, 10, 20));

		// Class ១២ក
		Student sDara = new Student(1l, "Dara", Gender.MALE, LocalDate.of(2005, 10, 20));
		Student sRy = new Student(2l, "Ry", Gender.FEMALE, LocalDate.of(2005, 10, 20));
		Student sSok = new Student(3l, "Sok", Gender.MALE, LocalDate.of(2005, 10, 20));
		// Class ១២ខ
		Student sNary = new Student(4l, "Nary", Gender.FEMALE, LocalDate.of(2005, 10, 20));
		Student sDom = new Student(5l, "Dom", Gender.MALE, LocalDate.of(2005, 10, 20));
		Student sLeang = new Student(6l, "Leang", Gender.FEMALE, LocalDate.of(2004, 10, 20));
		Student sKong = new Student(7l, "Kong", Gender.MALE, LocalDate.of(2005, 10, 20));
		Student sChan = new Student(8l, "Chan", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		// Class ១១ក
		Student sDalin = new Student(9l, "Dalin", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		Student sKompheak = new Student(10l, "Kompheak", Gender.MALE, LocalDate.of(2006, 10, 20));
		Student sPheak = new Student(11l, "Pheak", Gender.MALE, LocalDate.of(2006, 10, 20));
		Student sKdey = new Student(12l, "Kdey", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		// Class ១១ខ
		Student sPheatra = new Student(13l, "Pheaktra", Gender.MALE, LocalDate.of(2006, 10, 20));
		Student sTra = new Student(14l, "Tra", Gender.MALE, LocalDate.of(2006, 10, 20));
		Student sChetra = new Student(15l, "Chetra", Gender.MALE, LocalDate.of(2006, 10, 20));
		// Class 10ក
		Student sCheata = new Student(16l, "Cheata", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sSocheat = new Student(17l, "Socheat", Gender.MALE, LocalDate.of(2007, 10, 20));
		Student sSam = new Student(18l, "Sam", Gender.MALE, LocalDate.of(2007, 10, 20));
		Student sCheng = new Student(19l, "Cheng", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sMealea = new Student(20l, "Mealea", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		// Class ១០ខ
		Student sSochea = new Student(21l, "Sochea", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sReaksa = new Student(22l, "Reaksa", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sRangsey = new Student(23l, "Rangsey", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sPisey = new Student(24l, "Pisey", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Student sSomnang = new Student(25l, "Somnang", Gender.MALE, LocalDate.of(2007, 10, 20));
		Student sSan = new Student(26l, "San", Gender.MALE, LocalDate.of(2007, 10, 20));
		// Class ៩ក
		Student sMom = new Student(27l, "sMom", Gender.FEMALE, LocalDate.of(2008, 10, 20));
		Student sSrey = new Student(28l, "Srey", Gender.FEMALE, LocalDate.of(2008, 10, 20));
		Student sKakada = new Student(29l, "Kakada", Gender.MALE, LocalDate.of(2008, 10, 20));
		Student sVichet = new Student(30l, "Vichet", Gender.MALE, LocalDate.of(2009, 10, 20));
		Student sMeng = new Student(31l, "Meng", Gender.MALE, LocalDate.of(2010, 10, 20));
		Student sSensok = new Student(32l, "Sensok", Gender.MALE, LocalDate.of(2010, 10, 20));
		// Class ៩ខ
		Student sKa = new Student(33l, "Ka", Gender.FEMALE, LocalDate.of(2009, 10, 20));
		Student sSnar = new Student(34l, "Snar", Gender.MALE, LocalDate.of(2009, 10, 20));
		Student sSmey = new Student(35l, "Smey", Gender.FEMALE, LocalDate.of(2009, 10, 20));
		Student sVorak = new Student(36l, "Vorak", Gender.MALE, LocalDate.of(2009, 10, 20));
		// Class ៩គ
		Student sRina = new Student(37l, "Rina", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Student sPhally = new Student(38l, "Phally", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Student sPhanna = new Student(39l, "Phanna", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Student sSophea = new Student(40l, "Sophea", Gender.MALE, LocalDate.of(2010, 10, 20));
		Student sSorphea = new Student(41l, "Sorphea", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Student sDalis = new Student(42l, "Dalis", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Student sDanny = new Student(43l, "Danny", Gender.FEMALE, LocalDate.of(2011, 10, 20));

		List<Classroom> mySchool = List.of(//
				new Classroom(1l, 2023, 12, "ក", List.of(tSamnang, tSoksan, tChenda), List.of(sDara, sRy, sSok)),
				new Classroom(2l, 2023, 12, "ខ", List.of(tVeasna, tSoksan, tSeyha),
						List.of(sNary, sDom, sLeang, sKong, sChan)),
				new Classroom(3l, 2023, 11, "ក", List.of(tSamnang, tMakara, tKunthea),
						List.of(sDalin, sKompheak, sPheak, sKdey)),
				new Classroom(4l, 2023, 11, "ខ", List.of(tSamnang, tMakara, tChenda), List.of(sPheatra, sTra, sChetra)),
				new Classroom(5l, 2023, 10, "ក", List.of(tSamnang, tSoksan, tSeyha),
						List.of(sCheata, sSocheat, sSam, sCheng, sMealea)),
				new Classroom(6l, 2023, 10, "ខ", List.of(tSamnang, tSoksan, tSovath),
						List.of(sSochea, sReaksa, sRangsey, sPisey, sSomnang, sSan)),
				new Classroom(7l, 2023, 9, "ក", List.of(tVeasna, tMakara, tSovath),
						List.of(sMom, sSrey, sKakada, sVichet, sMeng, sSensok)),
				new Classroom(8l, 2023, 9, "ខ", List.of(tVeasna, tMakara, tSovath), List.of(sKa, sSnar, sSmey, sVorak)),
				new Classroom(9l, 2023, 9, "គ", List.of(tVeasna, tMakara, tKunthea),
						List.of(sRina, sPhally, sPhanna, sSophea, sSorphea, sDalis, sDanny)));

		return mySchool;
	}
}
