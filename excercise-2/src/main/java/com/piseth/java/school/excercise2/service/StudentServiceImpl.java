package com.piseth.java.school.excercise2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.piseth.java.school.excercise2.domain.DStudent;
import com.piseth.java.school.excercise2.exception.ResourceNotFoundException;
import com.piseth.java.school.excercise2.repository.StudentRepository;
import com.piseth.java.school.excercise2.spec.StudentFilter;
import com.piseth.java.school.excercise2.spec.StudentSpec;
import com.piseth.java.school.excercise2.util.PageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repo;

	@Override
	public DStudent getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", id));
	}

	@Override
	public Page<DStudent> getPage(StudentFilter filter, int page, int pageSize, String sortBy, boolean ascending) {
		StudentSpec spec = new StudentSpec(filter);
		Pageable pageable = PageUtil.getPageable(page, pageSize, sortBy, ascending);
		return repo.findAll(spec, pageable);
	}

	@Override
	public DStudent create(DStudent student) {
		return repo.save(student);
	}

	@Override
	public DStudent update(Long id, DStudent student) {
		DStudent dom = getById(id);

		dom.setDob(student.getDob());
		dom.setGender(student.getGender());
		dom.setName(student.getName());
		
		return repo.save(dom);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
