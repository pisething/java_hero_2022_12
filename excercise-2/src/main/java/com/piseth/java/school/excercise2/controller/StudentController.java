package com.piseth.java.school.excercise2.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.school.excercise2.domain.DStudent;
import com.piseth.java.school.excercise2.exception.ResourceNotFoundException;
import com.piseth.java.school.excercise2.json.JPage;
import com.piseth.java.school.excercise2.json.JStudent;
import com.piseth.java.school.excercise2.mapper.StudentMapper;
import com.piseth.java.school.excercise2.service.StudentService;
import com.piseth.java.school.excercise2.spec.StudentFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("student")
public class StudentController {

	private final StudentService service;

	/**
	 * Get student by ID
	 * 
	 * @param id database id of the student.
	 * @return student or an exception of {@link ResourceNotFoundException}
	 */
	@GetMapping("v1/{id}")
	public JStudent getById(@PathVariable Long id) {
		DStudent student = service.getById(id);
		return StudentMapper.INSTANCE.toJson(student);
	}

	@GetMapping("v1")
	public JPage<JStudent> getPage(@ModelAttribute StudentFilter filter, //
			@RequestParam(defaultValue = "0") int page, //
			@RequestParam(value = "pagesize", defaultValue = "10") int pageSize, //
			@RequestParam(value = "sortby", defaultValue = "name") String sortBy, //
			@RequestParam(value = "ascending", defaultValue = "true") boolean ascending) {

		Page<DStudent> dStudents = service.getPage(filter, page, pageSize, sortBy, ascending);
		Page<JStudent> jStudents = dStudents.map(s -> StudentMapper.INSTANCE.toJson(s));
		JPage<JStudent> result = new JPage<JStudent>(jStudents);
		return result;
	}

	@PostMapping(value = "v1", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JStudent create(@RequestBody JStudent jStudent) {
		DStudent student = StudentMapper.INSTANCE.toDomain(jStudent);
		student = service.create(student);
		return StudentMapper.INSTANCE.toJson(student);
	}

	@PutMapping(value = "v1/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JStudent update(@PathVariable Long id, @RequestBody JStudent jStudent) {
		DStudent student = StudentMapper.INSTANCE.toDomain(jStudent);
		student = service.update(id, student);
		return StudentMapper.INSTANCE.toJson(student);
	}

	@DeleteMapping("v1/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
