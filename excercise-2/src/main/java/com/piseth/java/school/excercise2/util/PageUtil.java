package com.piseth.java.school.excercise2.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.piseth.java.school.excercise2.exception.InvalidArgumentsException;

public interface PageUtil {
	int DEFAULT_PAGE = 0;
	int DEFAULT_PAGE_SIZE = 10;
	int MAX_PAGE_SIZE = 500;

	static Pageable getPageable(int page, int pageSize) {
		if (page < DEFAULT_PAGE) {
			throw new InvalidArgumentsException("page", Integer.toString(page));
		}
		
		if (pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {
			throw new InvalidArgumentsException("pagesize", Integer.toString(pageSize));
		}

		return PageRequest.of(page, pageSize);
	}
	
	static Pageable getPageable(int page, int pageSize, String sortBy, boolean ascending) {
		if (page < DEFAULT_PAGE) {
			throw new InvalidArgumentsException("page", Integer.toString(page));
		}
		
		if (pageSize <= 0 || pageSize > MAX_PAGE_SIZE) {
			throw new InvalidArgumentsException("pagesize", Integer.toString(pageSize));
		}

		return PageRequest.of(page, pageSize, Sort.by(ascending ? Direction.ASC : Direction.DESC, sortBy));
	}
}
