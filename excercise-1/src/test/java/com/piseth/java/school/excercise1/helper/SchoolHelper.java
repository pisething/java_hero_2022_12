package com.piseth.java.school.excercise1.helper;

import java.time.LocalDate;
import java.util.List;

import com.piseth.java.school.excercise1.model.ClassRoom;
import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Student;
import com.piseth.java.school.excercise1.model.Subject;
import com.piseth.java.school.excercise1.model.Teacher;

public class SchoolHelper {

	// For util class should have private constructor
	private SchoolHelper() {
	}

	// Create Subject
	public static List<Subject> getSubjects() {
		return List.of(
				new Subject(1L, "Math"),
				new Subject(2L, "Khmer"),
				new Subject(3L, "Java"),
				new Subject(4L, "Thai")
				);
	}

	// Create Teacher
	public static List<Teacher> getTeachers() {
		List<Subject> subjects = getSubjects();
		List<Teacher> teachers = List.of(
				new Teacher(1L, "Samnang", Gender.MALE, LocalDate.of(1990, 1, 31), subjects.get(0)),
				new Teacher(2L, "Piseth", Gender.MALE, LocalDate.of(1992, 2, 20), subjects.get(2)),
				new Teacher(3L, "Sovanna", Gender.MALE, LocalDate.of(1989, 4, 15), subjects.get(1)),
				new Teacher(4L, "Veasna", Gender.MALE, LocalDate.of(1993, 3, 20), subjects.get(3)),
				new Teacher(5L, "Vannary", Gender.FEMALE, LocalDate.of(1985, 2, 10), subjects.get(2)));
		return teachers;
	}

	// Create Student
	public static List<Student> getStudents() {
		return List.of(
				new Student(1L, "Dara", Gender.MALE, LocalDate.of(2002, 5, 10)), //Class 12A
				new Student(2L, "Thida", Gender.FEMALE, LocalDate.of(2003, 5, 20)), //Class 12A
				new Student(3L, "Cheata", Gender.FEMALE, LocalDate.of(2000, 5, 12)), //Class 12A
				new Student(4L, "Reaksmey", Gender.FEMALE, LocalDate.of(2000, 3, 30)), //Class 12A
				new Student(5L, "Nika", Gender.FEMALE, LocalDate.of(2003, 5, 20)), //Class 12B
				new Student(6L, "Vannda", Gender.MALE, LocalDate.of(2004, 2, 20)), //Class 12B
				new Student(7L, "Socheata", Gender.FEMALE, LocalDate.of(2001, 7, 21)), //Class 12B
				new Student(8L, "Vanny", Gender.MALE, LocalDate.of(2002, 8, 30)), //Class 12B
				new Student(9L, "Many", Gender.FEMALE, LocalDate.of(2002, 9, 24)), //Class 11A
				new Student(10L, "Vireak", Gender.MALE, LocalDate.of(2003, 1, 2)), //Class 11A
				new Student(11L, "Romchang", Gender.FEMALE, LocalDate.of(2003, 9, 10)), //Class 10A
				new Student(12L, "Soksan", Gender.MALE, LocalDate.of(2000, 5, 10)), //Class 10A
				new Student(13L, "Sovan", Gender.MALE, LocalDate.of(2004, 8, 20)), //Class 9A
				new Student(14L, "Veasna", Gender.MALE, LocalDate.of(2004, 3, 2)));  //Class 9A
	}

	// Create ClassRoom

	public static List<ClassRoom> getClassRooms() {
		List<Teacher> teachers = getTeachers();
		List<Student> students = getStudents();
		return List.of(
				new ClassRoom(1L, "A", 12, 2022, teachers.subList(0, 2), students.subList(0, 4)),
				new ClassRoom(2L, "B", 12, 2022, teachers.subList(0, 2), students.subList(4, 8)),
				new ClassRoom(3L, "A", 11, 2022, teachers.subList(1, 3), students.subList(8, 10)),
				new ClassRoom(4L, "A", 10, 2021, teachers.subList(2, 4), students.subList(10, 12)),
				new ClassRoom(3L, "A", 9, 2020, teachers.subList(2, 3), students.subList(12, 14)));
	}

}
