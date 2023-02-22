package com.piseth.java.school.excercise2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piseth.java.school.excercise2.domain.DStudent;
import com.piseth.java.school.excercise2.json.JStudent;

@Mapper
public interface StudentMapper {

	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

	DStudent toDomain(JStudent j);
	JStudent toJson(DStudent d);
}
