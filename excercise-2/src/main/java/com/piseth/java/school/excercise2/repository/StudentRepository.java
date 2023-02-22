package com.piseth.java.school.excercise2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.piseth.java.school.excercise2.domain.DStudent;

public interface StudentRepository extends JpaRepository<DStudent, Long>, JpaSpecificationExecutor<DStudent> {

}
