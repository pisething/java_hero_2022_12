package com.piseth.java.school.excercise2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject")
public class DSubject extends AbstractEntity {
	private String name;
}
