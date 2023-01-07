package com.piseth.java.school.excercise1.service.Impl;

import com.piseth.java.school.excercise1.model.Gender;
import com.piseth.java.school.excercise1.model.Role;
import com.piseth.java.school.excercise1.model.User;
import com.piseth.java.school.excercise1.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public Long getNumberOfMaleTeacher(List<User> list) {
        return list.stream()
                .filter(u -> u.getRole() == Role.TEACHER)
                .filter(u -> u.getGender() == Gender.MALE)
                .count();
    }
    @Override
    public Long getNumberOfFemaleStudent12ក(List<User> list) {
//        list.stream()
//                .filter(u -> u.getRole() == Role.STUDENT)
//                .filter(u -> u.getGender() == Gender.FEMALE)
//                .filter(u -> u.getYear().stream().map(y -> y.))
       return  null;
    }

    @Override
    public Long getNumberOfSamnangStudent(List<User> list) {
        return null;
    }

    @Override
    public Long getNumberOfClassSamnangTeachingIn2022To2023(List<User> list) {
        return null;
    }

    @Override
    public Long getNumberOfTeacherAndStudent(List<User> list) {
        return null;
    }

    @Override
    public Gender getGenderOfOldestTeacher(List<User> list) {
        return null;
    }

    @Override
    public List<User> getTeacherHaveStudentMoreThan100(List<User> list) {
        return null;
    }

    @Override
    public User getClassHaveTheMostMaleStudent(List<User> list) {
        return null;
    }

    @Override
    public User getYoungestStudent(List<User> list) {
        return null;
    }

    @Override
    public Long getNumberOfClass12(List<User> list) {
        return null;
    }

    @Override
    public Map<String, Long> getNumberOfStudentGroupByYear(List<User> list) {
        return null;
    }
}
