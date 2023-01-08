package com.piseth.java.school.excercise1.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Person;
import com.piseth.java.school.excercise1.domain.Teacher;

import lombok.Data;

@Data
public class SchoolServiceImpl implements SchoolService {

	private List<Classroom> mySchool;

	@Override
	public Long countTeacherByGender(Gender gender) {
		Map<Gender, Long> result = mySchool.stream().flatMap(c -> c.getTeachers().stream()).distinct()
				.collect(Collectors.groupingBy(Teacher::getGender, Collectors.counting()));
		return result.get(gender);
	}

	@Override
	public Long countStudentByClassAndGender(int grade, String className, Gender gender) {
		Map<Gender, Long> result = mySchool.stream().filter(c -> c.getGrade() == grade && c.getName().equals(className))
				.flatMap(c -> c.getStudents().stream())
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		return result.get(gender);
	}

	@Override
	public Long countStudentByTeacher(String tName) {
		Long result = mySchool.stream().filter(c -> c.getTeachers().stream().anyMatch(t -> t.getName().equals(tName)))
				.flatMap(c -> c.getStudents().stream()).collect(Collectors.counting());
		return result;
	}

	@Override
	public Long countClassByTeacherAndSchoolYear(String tName, int schoolYear) {
		Long result = mySchool.stream().filter(c -> c.getSchoolYear() == schoolYear)
				.filter(c -> c.getTeachers().stream().anyMatch(t -> t.getName().equals(tName)))
				.collect(Collectors.counting());
		return result;
	}

	@Override
	public Long countAllStudentAndTeacher() {
		Long teacherCount = mySchool.stream().flatMap(c -> c.getTeachers().stream()).distinct()
				.collect(Collectors.counting());
		Long studentCount = mySchool.stream().flatMap(c -> c.getStudents().stream()).distinct()
				.collect(Collectors.counting());
		return teacherCount + studentCount;
	}

	@Override
	public Gender getGenderOfEldestTeacher() {
		Optional<Teacher> eldestTeacher = mySchool.stream().flatMap(c -> c.getTeachers().stream()).distinct()
				.collect(Collectors.maxBy(Comparator.comparing(Teacher::getAge)));
		if (eldestTeacher.isPresent()) {
			return eldestTeacher.get().getGender();
		} else {
			return null;
		}
	}

	@Override
	public List<String> getTeachersWithStudentMoreThanN(int numberOfStudents) {
		Map<String, Integer> teacherStudentCounts = new HashMap<>();
		mySchool.stream().forEach(clss -> {
			int studentCount = clss.getStudents().size();
			clss.getTeachers().forEach(teacher -> {
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
	public Person getYoungestStudent() {
		List<Person> students = mySchool.stream().flatMap(c -> c.getStudents().stream())
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
