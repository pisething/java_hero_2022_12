package com.piseth.java.school.excercise1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Year {
    private String year;
    private List<Class> classes;

}
