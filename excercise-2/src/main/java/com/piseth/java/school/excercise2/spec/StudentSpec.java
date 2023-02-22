package com.piseth.java.school.excercise2.spec;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.piseth.java.school.excercise2.domain.DStudent;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class StudentSpec implements Specification<DStudent> {
	
	private final StudentFilter filter;

	@Override
	public Predicate toPredicate(Root<DStudent> student, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> pds = new LinkedList<Predicate>();
		if (StringUtils.isNotBlank(filter.getName())) {
			Predicate pd = cb.like(student.get("name"), "%" + filter.getName().replace(' ', '%') + "%");
			pds.add(pd);
		}
		if (filter.getGender() != null) {
			pds.add(student.get("gender").in(filter.getGender()));
		}
		if (filter.getId() != null) {
			pds.add(student.get("id").in(filter.getId()));
		}
		// return cb.and(pds.toArray(new Predicate[0])); // convert list to array.
		return cb.and(pds.toArray(Predicate[]::new));
	}
}
