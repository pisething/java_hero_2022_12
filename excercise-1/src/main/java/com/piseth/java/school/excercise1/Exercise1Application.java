package com.piseth.java.school.excercise1;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Sex;
import com.piseth.java.school.excercise1.domain.Student;
import com.piseth.java.school.excercise1.domain.Teacher;
import com.piseth.java.school.excercise1.service.SchoolService;
import com.piseth.java.school.excercise1.service.SchoolServiceImpl;

/*
#java_hero_2022_12
ប្រធានបទទី១៖
សំណាងជាគ្រូផ្នែកគណិតវិទ្យា នៅវិទ្យាល័យមួយ។
ក្នុងឆ្នាំសិក្សា២០២២-២០២៣ គាត់មានសិស្សថ្នាក់ទី១០ចំនួន២ថ្នាក់ ថ្នាក់ទី១១ ចំនួន២ថ្នាក់ ថ្នាក់ទី១២ ចំនួន១ថ្នាក់។
ដោយមិនប្រើ Database ចូរ Design classes ដែលអាចមាន និងដាក់ Sample Data
១. តើវិទ្យាល័យនេះមានគ្រូប្រុសប៉ុន្មាននាក់?
២. តើថ្នាក់ទី១២ក មានសិស្សស្រីប៉ុន្មាននាក់?
៣. តើសំណាងមានសិស្សសរុបប៉ុន្មាននាក់?
៤. តើសំណាងបង្រៀនប៉ុន្មានថ្នាក់ក្នុងឆ្នាំសិក្សា២០២២-២០២៣?
៥. ទាំងគ្រូនិងសិស្សតើមានចំនួនសរុបប៉ុន្មាន?
៦. គ្រូដែលមានអាយុច្រើនជាងគេ ជាគ្រូប្រុសឬស្រី?
៧. គ្រូណាខ្លះដែលមានសិស្សសរុបលើសពី១០០នាក់?
៨. ថ្នាក់ណាដែលមានសិស្សប្រុសច្រើនជាងគេ?
៩. សិស្សដែលក្មេងជាងគេមានឈ្មោះអ្វី?
១០. តើថ្នាក់ទី១២មានប៉ុន្មានថ្នាក់?
១១. ប្រៀបធៀបចំនួនសិស្សរវាងឆ្នាំសិក្សា២០២១-២០២២ និង ២០២២-២០២៣ ក្នុងវិទ្យាល័យនេះ
*/
@SpringBootApplication
public class Exercise1Application {
	private final SchoolService schoolService = new SchoolServiceImpl();

	public static void main(String[] args) {
		SpringApplication.run(Exercise1Application.class, args);
		Exercise1Application application = new Exercise1Application();

//		// ១. តើវិទ្យាល័យនេះមានគ្រូប្រុសប៉ុន្មាននាក់?
//		application.countTeacherBySex(Sex.MALE);
//		application.countTeacherBySex(Sex.FEMALE);
//		// ២. តើថ្នាក់ទី១២ក មានសិស្សស្រីប៉ុន្មាននាក់?
//		application.countStudentByClassAndSex(12, "ក", Sex.FEMALE);
//		application.countStudentByClassAndSex(12, "ក", Sex.MALE);
//		// ៣. តើសំណាងមានសិស្សសរុបប៉ុន្មាននាក់?
//		application.countStudentByTeacher("Samnang");
//		// ៤. តើសំណាងបង្រៀនប៉ុន្មានថ្នាក់ក្នុងឆ្នាំសិក្សា២០២២-២០២៣?
//		application.countClassByTeacherAndSchoolYear("Samnang", 2023);
//		// ៥. ទាំងគ្រូនិងសិស្សតើមានចំនួនសរុបប៉ុន្មាន?
//		application.countAllStudentAndTeacher();
//		// ៦. គ្រូដែលមានអាយុច្រើនជាងគេ ជាគ្រូប្រុសឬស្រី?
//		application.getSexOfEldestTeacher();
//		// ៧. គ្រូណាខ្លះដែលមានសិស្សសរុបលើសពី១០០នាក់?
		application.getTeachersWithStudentMoreThanN(20);
//		// ៨. ថ្នាក់ណាដែលមានសិស្សប្រុសច្រើនជាងគេ?
//		application.getClassWithMaxStudentBySex(Sex.MALE);
//		// ៩. សិស្សដែលក្មេងជាងគេមានឈ្មោះអ្វី?
//		application.getYoungestStudent();
//		// ១០. តើថ្នាក់ទី១២មានប៉ុន្មានថ្នាក់?
//		application.countClassByGrade(12);
//		// ១១. ប្រៀបធៀបចំនួនសិស្សរវាងឆ្នាំសិក្សា២០២១-២០២២ និង ២០២២-២០២៣
//		// ក្នុងវិទ្យាល័យនេះ
//		application.countAllStudentBySchoolYear(2023);
//		application.countAllStudentBySchoolYear(2022);
	}

	public Long countTeacherBySex(Sex sex) {
		Long count = schoolService.countTeacherBySex(sex);
		System.out.println("Total of " + sex + " teachers is: " + count);
		return count;
	}

	public Long countStudentByClassAndSex(int grade, String className, Sex sex) {
		Long count = schoolService.countStudentByClassAndSex(grade, className, sex);
		System.out.println(String.format("Total of %s students in class %d%s is: %d", sex, grade, className, count));
		return count;
	}

	public Long countStudentByTeacher(String tName) {
		Long count = schoolService.countStudentByTeacher(tName);
		System.out.println(String.format("Teacher '%s' has %d students", tName, count));
		return count;
	}

	public Long countClassByTeacherAndSchoolYear(String tName, int schoolYear) {
		Long count = schoolService.countClassByTeacherAndSchoolYear(tName, schoolYear);
		System.out.println(String.format("For year %d, T.'%s' has %d class(es)", schoolYear, tName, count));
		return count;
	}

	public Long countAllStudentAndTeacher() {
		Long count = schoolService.countAllStudentAndTeacher();
		System.out.println(String.format("Total number of teachers and students is: %d", count));
		return count;
	}

	public Sex getSexOfEldestTeacher() {
		Sex sex = schoolService.getSexOfEldestTeacher();
		System.out.println(String.format("The eldest teacher is a %s teacher.", sex));
		return sex;
	}

	public List<Teacher> getTeachersWithStudentMoreThanN(int numberOfStudents) {
		List<Teacher> teachers = schoolService.getTeachersWithStudentMoreThanN(numberOfStudents);
		System.out.println(String.format("These are the teachers with students more than %d:", numberOfStudents));
		teachers.stream().map(t -> String.format("%s : %d", t.getName(), t.getStudentCount())).forEach(System.out::println);
		return teachers;
	}

	public Classroom getClassWithMaxStudentBySex(Sex sex) {
		Classroom result = schoolService.getClassWithMaxStudentBySex(sex);
		System.out.println(String.format("Class with max %s students is: %d%s - %d", sex, result.getGrade(),
				result.getName(), result.getSchoolYear()));
		return result;
	}

	public Student getYoungestStudent() {
		Student result = schoolService.getYoungestStudent();
		System.out.println(String.format("The youngest student is: %s", result.getName()));
		return result;
	}

	public Long countClassByGrade(int grade) {
		Long count = schoolService.countClassByGrade(grade);
		System.out.println(String.format("Grade %d has %d class(es)", grade, count));
		return count;
	}

	public Long countAllStudentBySchoolYear(int schoolYear) {
		Long count = schoolService.countAllStudentBySchoolYear(schoolYear);
		System.out.println(String.format("Year %d there are %d student(s)", schoolYear, count));
		return count;
	}
}
