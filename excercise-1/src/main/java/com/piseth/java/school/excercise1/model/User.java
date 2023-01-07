package com.piseth.java.school.excercise1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private final Role role;
    private final Gender gender;
    private final List year;
}
