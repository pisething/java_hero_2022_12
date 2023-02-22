package com.piseth.java.school.excercise2.service;

import org.springframework.data.domain.Page;

import com.piseth.java.school.excercise2.domain.DStudent;
import com.piseth.java.school.excercise2.spec.StudentFilter;

public interface StudentService {

	DStudent getById(Long id);

	Page<DStudent> getPage(StudentFilter filter, int page, int pageSize, String sortBy, boolean ascending);

	DStudent create(DStudent student);

	DStudent update(Long id, DStudent student);

	void delete(Long id);
}
