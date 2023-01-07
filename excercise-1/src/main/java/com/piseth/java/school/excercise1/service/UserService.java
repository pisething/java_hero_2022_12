package com.piseth.java.school.excercise1.service;

import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Long getNumberOfMaleTeacher(List<User> list);

    Long getNumberOfFemaleStudent12ក(List<User> list);

    Long getNumberOfSamnangStudent(List<User> list);

    Long getNumberOfClassSamnangTeachingIn2022To2023(List<User> list);

    Long getNumberOfTeacherAndStudent(List<User> list);

    Gender getGenderOfOldestTeacher(List<User> list);

    List<User> getTeacherHaveStudentMoreThan100(List<User> list);

    User getClassHaveTheMostMaleStudent(List<User> list);

    User getYoungestStudent(List<User> list);

    Long getNumberOfClass12(List<User> list);

    Map<String, Long> getNumberOfStudentGroupByYear(List<User> list);
}
