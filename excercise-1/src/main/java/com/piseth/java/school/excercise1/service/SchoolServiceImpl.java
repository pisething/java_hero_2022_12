package com.piseth.java.school.excercise1.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Person;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Teacher;

import lombok.Data;

@Data
public class SchoolServiceImpl implements SchoolService {

	private List<Classroom> mySchool;

	@Override
	public Long countTeacherByGender(int schoolYear, Gender gender) {
		return mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)//
				.flatMap(c -> c.getTeachers().stream())//
				.filter(t -> t.getGender() == gender)//
				.distinct()//
				.count();
	}

	@Override
	public Long countStudentByClassAndGender(int schoolYear, int grade, String className, Gender gender) {
		return mySchool.stream()//
		.filter(c -> c.getSchoolYear() == schoolYear && c.getGrade() == grade && c.getName().equals(className))//
		.flatMap(c -> c.getStudents().stream())//
		.filter(s -> s.getGender() == gender)
		.count();
	}

	@Override
	public Long countStudentByTeacher(int schoolYear, String tName) {
		Long result = mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)//
				.filter(c -> c.getTeachers().stream().anyMatch(t -> t.getName().equals(tName)))
				.flatMap(c -> c.getStudents().stream()).distinct().count();
		// same teacher might have mistakenly added to same class more than 1 time.
		return result;
	}

	@Override
	public Long countClassByTeacherAndSchoolYear(int schoolYear, String tName) {
		Long result = mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)
				.filter(c -> c.getTeachers().stream().anyMatch(t -> t.getName().equals(tName)))
				.count();
		return result;
	}

	@Override
	public Long countAllStudentAndTeacher(int schoolYear) {
		Long teacherCount = mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)//
				.flatMap(c -> c.getTeachers().stream()).distinct().count();

		Long studentCount = mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)//
				.flatMap(c -> c.getStudents().stream()).distinct().count();

		return teacherCount + studentCount;
	}

	@Override
	public Gender getGenderOfEldestTeacher(int schoolYear) {
		Optional<Teacher> eldestTeacher = mySchool.stream()//
				.filter(c -> c.getSchoolYear() == schoolYear)//
				.flatMap(c -> c.getTeachers().stream())//
				.distinct()
				.max(Comparator.comparing(Teacher::getAge));

		if (eldestTeacher.isPresent()) {
			return eldestTeacher.get().getGender();
		} else {
			return null;
		}
	}

	@Override
	public List<String> getTeachersWithStudentMoreThanN(int schoolYear, int numberOfStudents) {
		Map<String, Integer> teacherStudentCounts = new HashMap<>();
		mySchool.stream()//
			.filter(c -> c.getSchoolYear() == schoolYear)//
			.forEach(c -> {
			int studentCount = c.getStudents().size();
			c.getTeachers().forEach(teacher -> {
				int s = teacherStudentCounts.get(teacher.getName()) == null ? 0 : teacherStudentCounts.get(teacher.getName());
				teacherStudentCounts.put(teacher.getName(), studentCount + s);
			});
		});

		return teacherStudentCounts.entrySet().stream().filter(t -> t.getValue() > numberOfStudents)
				.map(t -> t.getKey()).toList();
	}

	@Override
	public Classroom getClassWithMaxStudentByGender(Gender gender) {
		List<Classroom> classroom = mySchool.stream()
				.sorted(Comparator.comparing(Classroom::getStudents, (cs1, cs2) -> {
					return (int) (cs1.stream().filter(s -> s.getGender().equals(gender)).count()
							- cs2.stream().filter(ss -> ss.getGender().equals(gender)).count());
				}).reversed()).toList();
		return classroom.get(0);
	}

	@Override
	public Student getYoungestStudent() {
		List<Student> students = mySchool.stream().flatMap(c -> c.getStudents().stream())
				.sorted(Comparator.comparing(Person::getAge)).toList();
		return students.get(0);
	}

	@Override
	public Long countClassByGrade(int grade) {
		return mySchool.stream().filter(c -> c.getGrade() == grade).count();
	}

	@Override
	public Long countAllStudentBySchoolYear(int schoolYear) {
		return mySchool.stream().filter(c -> c.getSchoolYear() == schoolYear).flatMap(c -> c.getStudents().stream())
				.count();
	}

	public SchoolServiceImpl() {
		super();
	}
	
	@Override
	public void initData() {
		mySchool = DataUtils.initData();
	}
}
