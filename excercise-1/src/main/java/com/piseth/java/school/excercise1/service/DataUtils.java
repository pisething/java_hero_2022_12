package com.piseth.java.school.excercise1.service;

import java.time.LocalDate;
import java.util.List;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Person;
import com.piseth.java.school.excercise1.domain.Subject;
import com.piseth.java.school.excercise1.domain.Teacher;

public class DataUtils {

	public static List<Classroom> initData() {
		// My school contain list of teachers, list of classes, list of students
		Teacher tSamnang = new Teacher(Subject.MATH, "Samnang", Gender.MALE, LocalDate.of(1990, 10, 20));
		Teacher tVeasna = new Teacher(Subject.MATH, "Veasna", Gender.FEMALE, LocalDate.of(1994, 10, 20));
		Teacher tSoksan = new Teacher(Subject.PHYSICS, "Soksan", Gender.FEMALE, LocalDate.of(1983, 10, 20));
		Teacher tMakara = new Teacher(Subject.PHYSICS, "Makara", Gender.FEMALE, LocalDate.of(1982, 10, 20));
		Teacher tKunthea = new Teacher(Subject.KHMER, "Kunthea", Gender.FEMALE, LocalDate.of(1996, 10, 20));
		Teacher tSovath = new Teacher(Subject.KHMER, "Sovath", Gender.MALE, LocalDate.of(1990, 10, 20));
		Teacher tSeyha = new Teacher(Subject.KHMER, "Seyha", Gender.MALE, LocalDate.of(1974, 10, 20));
		Teacher tChenda = new Teacher(Subject.KHMER, "Chenda", Gender.FEMALE, LocalDate.of(1977, 10, 20));

		// Class ១២ក
		Person sDara = new Person("Dara", Gender.MALE, LocalDate.of(2005, 10, 20));
		Person sRy = new Person("Ry", Gender.FEMALE, LocalDate.of(2005, 10, 20));
		Person sSok = new Person("Sok", Gender.MALE, LocalDate.of(2005, 10, 20));
		// Class ១២ខ
		Person sNary = new Person("Nary", Gender.FEMALE, LocalDate.of(2005, 10, 20));
		Person sDom = new Person("Dom", Gender.MALE, LocalDate.of(2005, 10, 20));
		Person sLeang = new Person("Leang", Gender.FEMALE, LocalDate.of(2004, 10, 20));
		Person sKong = new Person("Kong", Gender.MALE, LocalDate.of(2005, 10, 20));
		Person sChan = new Person("Chan", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		// Class ១១ក
		Person sDalin = new Person("Dalin", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		Person sKompheak = new Person("Kompheak", Gender.MALE, LocalDate.of(2006, 10, 20));
		Person sPheak = new Person("Pheak", Gender.MALE, LocalDate.of(2006, 10, 20));
		Person sKdey = new Person("Kdey", Gender.FEMALE, LocalDate.of(2006, 10, 20));
		// Class ១១ខ
		Person sPheatra = new Person("Pheaktra", Gender.MALE, LocalDate.of(2006, 10, 20));
		Person sTra = new Person("Tra", Gender.MALE, LocalDate.of(2006, 10, 20));
		Person sChetra = new Person("Chetra", Gender.MALE, LocalDate.of(2006, 10, 20));
		// Class 10ក
		Person sCheata = new Person("Cheata", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sSocheat = new Person("Socheat", Gender.MALE, LocalDate.of(2007, 10, 20));
		Person sSam = new Person("Sam", Gender.MALE, LocalDate.of(2007, 10, 20));
		Person sCheng = new Person("Cheng", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sMealea = new Person("Mealea", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		// Class ១០ខ
		Person sSochea = new Person("Sochea", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sReaksa = new Person("Reaksa", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sRangsey = new Person("Rangsey", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sPisey = new Person("Pisey", Gender.FEMALE, LocalDate.of(2007, 10, 20));
		Person sSomnang = new Person("Somnang", Gender.MALE, LocalDate.of(2007, 10, 20));
		Person sSan = new Person("San", Gender.MALE, LocalDate.of(2007, 10, 20));
		// Class ៩ក
		Person sMom = new Person("sMom", Gender.FEMALE, LocalDate.of(2008, 10, 20));
		Person sSrey = new Person("Srey", Gender.FEMALE, LocalDate.of(2008, 10, 20));
		Person sKakada = new Person("Kakada", Gender.MALE, LocalDate.of(2008, 10, 20));
		Person sVichet = new Person("Vichet", Gender.MALE, LocalDate.of(2009, 10, 20));
		Person sMeng = new Person("Meng", Gender.MALE, LocalDate.of(2010, 10, 20));
		Person sSensok = new Person("Sensok", Gender.MALE, LocalDate.of(2010, 10, 20));
		// Class ៩ខ
		Person sKa = new Person("Ka", Gender.FEMALE, LocalDate.of(2009, 10, 20));
		Person sSnar = new Person("Snar", Gender.MALE, LocalDate.of(2009, 10, 20));
		Person sSmey = new Person("Smey", Gender.FEMALE, LocalDate.of(2009, 10, 20));
		Person sVorak = new Person("Vorak", Gender.MALE, LocalDate.of(2009, 10, 20));
		// Class ៩គ
		Person sRina = new Person("Rina", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Person sPhally = new Person("Phally", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Person sPhanna = new Person("Phanna", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Person sSophea = new Person("Sophea", Gender.MALE, LocalDate.of(2010, 10, 20));
		Person sSorphea = new Person("Sorphea", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Person sDalis = new Person("Dalis", Gender.FEMALE, LocalDate.of(2010, 10, 20));
		Person sDanny = new Person("Danny", Gender.FEMALE, LocalDate.of(2011, 10, 20));

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
		
		return mySchool;
	}
}
