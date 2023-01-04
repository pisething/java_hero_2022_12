package com.piseth.java.school.excercise1.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Sex;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Subject;
import com.piseth.java.school.excercise1.domain.Teacher;

import lombok.Data;

@Data
public class SchoolServiceImpl implements SchoolService {

	private List<Classroom> mySchool;

	@Override
	public Long countTeacherBySex(Sex sex) {
		Map<Sex, Long> result = mySchool.stream().flatMap(c -> c.getTeachers().stream()).distinct()
				.collect(Collectors.groupingBy(Teacher::getSex, Collectors.counting()));
		return result.get(sex);
	}

	@Override
	public Long countStudentByClassAndSex(int grade, String className, Sex sex) {
		Map<Sex, Long> result = mySchool.stream().filter(c -> c.getGrade() == grade && c.getName().equals(className))
				.flatMap(c -> c.getStudents().stream())
				.collect(Collectors.groupingBy(Student::getSex, Collectors.counting()));
		return result.get(sex);
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
	public Sex getSexOfEldestTeacher() {
		Optional<Teacher> eldestTeacher = mySchool.stream().flatMap(c -> c.getTeachers().stream()).distinct()
				.collect(Collectors.maxBy(Comparator.comparing(Teacher::getAge)));
		if (eldestTeacher.isPresent()) {
			return eldestTeacher.get().getSex();
		} else {
			return null;
		}
	}

	@Override
	public List<Teacher> getTeachersWithStudentMoreThanN(int numberOfStudents) {
		// Group them together by adding students count and group by teacher's name
		Map<String, Teacher> tts = mySchool.stream().flatMap(classroom -> classroom.getTeachers().stream())
				.collect(Collectors.toMap(Teacher::getName, Function.identity(), (t1, t2) -> {
					// t1.setStudentCount(t1.getStudentCount() + t2.getStudentCount());
					return t1;
				}));

		// Filter
		return tts.values().stream().filter(t -> t.getStudentCount() > numberOfStudents).toList();
	}

	@Override
	public Classroom getClassWithMaxStudentBySex(Sex sex) {
		List<Classroom> classroom = mySchool.stream()
				.sorted(Comparator.comparing(Classroom::getStudents, (cs1, cs2) -> {
					return (int) (cs1.stream().filter(s -> s.getSex().equals(sex)).count()
							- cs2.stream().filter(ss -> ss.getSex().equals(sex)).count());
				}).reversed()).toList();
		return classroom.get(0);
	}

	@Override
	public Student getYoungestStudent() {
		List<Student> students = mySchool.stream().flatMap(c -> c.getStudents().stream())
				.sorted(Comparator.comparing(Student::getAge)).toList();
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

	public void initData() {
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

		mySchool = List.of(//
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
	}
}
