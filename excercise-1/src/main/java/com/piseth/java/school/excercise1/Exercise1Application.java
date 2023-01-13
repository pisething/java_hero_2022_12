package com.piseth.java.school.excercise1;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.piseth.java.school.excercise1.domain.Classroom;
import com.piseth.java.school.excercise1.domain.Gender;
import com.piseth.java.school.excercise1.domain.Person;
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
		application.schoolService.initData();

		// ១. តើវិទ្យាល័យនេះមានគ្រូប្រុសប៉ុន្មាននាក់?
		application.countTeacherByGender(2023, Gender.MALE);
		application.countTeacherByGender(2023, Gender.FEMALE);
		// ២. តើថ្នាក់ទី១២ក មានសិស្សស្រីប៉ុន្មាននាក់?
		application.countStudentByClassAndGender(2023, 12, "ក", Gender.FEMALE);
		application.countStudentByClassAndGender(2023, 12, "ក", Gender.MALE);
		// ៣. តើសំណាងមានសិស្សសរុបប៉ុន្មាននាក់?
		application.countStudentByTeacher(2023, "Samnang");
		// ៤. តើសំណាងបង្រៀនប៉ុន្មានថ្នាក់ក្នុងឆ្នាំសិក្សា២០២២-២០២៣?
		application.countClassByTeacherAndSchoolYear(2023, "Samnang");
		// ៥. ទាំងគ្រូនិងសិស្សតើមានចំនួនសរុបប៉ុន្មាន?
		application.countAllStudentAndTeacher(2023);
		// ៦. គ្រូដែលមានអាយុច្រើនជាងគេ ជាគ្រូប្រុសឬស្រី?
		application.getGenderOfEldestTeacher(2023);
		// ៧. គ្រូណាខ្លះដែលមានសិស្សសរុបលើសពី១០០នាក់?
		application.getTeachersWithStudentMoreThanN(2023, 20);
		// ៨. ថ្នាក់ណាដែលមានសិស្សប្រុសច្រើនជាងគេ?
		application.getClassWithMaxStudentBySex(Gender.MALE);
		// ៩. សិស្សដែលក្មេងជាងគេមានឈ្មោះអ្វី?
		application.getYoungestStudent();
		// ១០. តើថ្នាក់ទី១២មានប៉ុន្មានថ្នាក់?
		application.countClassByGrade(12);
		// ១១. ប្រៀបធៀបចំនួនសិស្សរវាងឆ្នាំសិក្សា២០២១-២០២២ និង ២០២២-២០២៣
		// ក្នុងវិទ្យាល័យនេះ
		application.countAllStudentBySchoolYear(2023);
		application.countAllStudentBySchoolYear(2022);
	}

	public Long countTeacherByGender(int schoolYear, Gender gender) {
		Long count = schoolService.countTeacherByGender(schoolYear, gender);
		System.out.println("Total of " + gender + " teachers for " + schoolYear + " is: " + count);
		return count;
	}

	public Long countStudentByClassAndGender(int schoolYear, int grade, String className, Gender gender) {
		Long count = schoolService.countStudentByClassAndGender(schoolYear, grade, className, gender);
		System.out.println(String.format("Total of %s students in class %d%s (%d) is: %d", gender, grade, className, schoolYear, count));
		return count;
	}

	public Long countStudentByTeacher(int schoolYear, String tName) {
		Long count = schoolService.countStudentByTeacher(schoolYear, tName);
		System.out.println(String.format("Teacher '%s' has %d students in year %d", tName, count, schoolYear));
		return count;
	}

	public Long countClassByTeacherAndSchoolYear(int schoolYear, String tName) {
		Long count = schoolService.countClassByTeacherAndSchoolYear(schoolYear, tName);
		System.out.println(String.format("For year %d, T.'%s' has %d class(es)", schoolYear, tName, count));
		return count;
	}

	public Long countAllStudentAndTeacher(int schoolYear) {
		Long count = schoolService.countAllStudentAndTeacher(schoolYear);
		System.out.println(String.format("Total number of teachers and students in %d is: %d", schoolYear, count));
		return count;
	}

	public Gender getGenderOfEldestTeacher(int schoolYear) {
		Gender gender = schoolService.getGenderOfEldestTeacher(schoolYear);
		System.out.println(String.format("The eldest teacher is a %s teacher.", gender));
		return gender;
	}

	public List<String> getTeachersWithStudentMoreThanN(int schoolYear, int numberOfStudents) {
		List<String> teacherNames = schoolService.getTeachersWithStudentMoreThanN(schoolYear, numberOfStudents);
		System.out.println(String.format("These are the teachers with students more than %d in %d:", numberOfStudents, schoolYear));
		teacherNames.stream().forEach(System.out::println);
		return teacherNames;
	}

	public Classroom getClassWithMaxStudentBySex(Gender gender) {
		Classroom result = schoolService.getClassWithMaxStudentByGender(gender);
		System.out.println(String.format("Class with max %s students is: %d%s - %d", gender, result.getGrade(),
				result.getName(), result.getSchoolYear()));
		return result;
	}

	public Person getYoungestStudent() {
		Person result = schoolService.getYoungestStudent();
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
