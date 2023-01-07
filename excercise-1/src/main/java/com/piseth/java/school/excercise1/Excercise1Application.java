package com.piseth.java.school.excercise1;

import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Role;
import com.piseth.java.school.excercise1.model.User;
import com.piseth.java.school.excercise1.model.Year;
import com.piseth.java.school.excercise1.model.Class;
import com.piseth.java.school.excercise1.service.Impl.UserServiceImpl;
import com.piseth.java.school.excercise1.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Excercise1Application {

	UserService userService = new UserServiceImpl();

	private final List<User> users = List.of(
			new User("Somnang", Role.TEACHER, Gender.MALE, List.of(
					new Year("2021-2022", List.of(Class.ថ្នាក់ទី១០ក, Class.ថ្នាក់ទី១១គ, Class.ថ្នាក់ទី១២គ)),
					new Year("2022-2023", List.of(Class.ថ្នាក់ទី១០ក, Class.ថ្នាក់ទី១០ខ, Class.ថ្នាក់ទី១១គ, Class.ថ្នាក់ទី១១ក, Class.ថ្នាក់ទី១២ខ))
			)
			),
			new User("Vatey", Role.TEACHER, Gender.FEMALE, List.of(
					new Year ("2021-2022", List.of(Class.ថ្នាក់ទី១០ក, Class.ថ្នាក់ទី១២គ))
			)
			),
			new User("Vithyea", Role.STUDENT, Gender.MALE, List.of(
					new Year("2021-2022", List.of(Class.ថ្នាក់ទី១០ក)),
					new Year("2022-2023", List.of(Class.ថ្នាក់ទី១១ក))
			)
			),
			new User("Vuth", Role.STUDENT, Gender.MALE, List.of(
					new Year("2022-2023", List.of(Class.ថ្នាក់ទី១០ក))
			)
			),
			new User("Seavpey", Role.STUDENT, Gender.FEMALE, List.of(
					new Year("2021-2022", List.of(Class.ថ្នាក់ទី១២គ))
			)
			),
			new User("Vichet", Role.STUDENT, Gender.MALE, List.of(
					new Year("2021-2022", List.of(Class.ថ្នាក់ទី១១គ)),
					new Year("2022-2023", List.of(Class.ថ្នាក់ទី១០ក))
			)
			)
	);
	public static void main(String[] args) {
//		SpringApplication.run(Excercise1Application.class, args);

		Excercise1Application excercise1Application = new Excercise1Application();

		excercise1Application.getNumberOfMaleTeacher();

	}

	void getNumberOfMaleTeacher() {
		System.out.println("=========== Count Total Male Teacher ============");
		final Long numberOfMaleTeacher = userService.getNumberOfMaleTeacher(users);
		System.out.println(numberOfMaleTeacher);
	}

}
