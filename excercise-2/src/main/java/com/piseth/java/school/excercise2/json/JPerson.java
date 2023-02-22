package com.piseth.java.school.excercise2.json;

import java.time.LocalDate;

import com.piseth.java.school.excercise2.domain.Gender;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class JPerson extends JBaseObject {
	private String name;
	private Gender gender;
	private LocalDate dob;
}
