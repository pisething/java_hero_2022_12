package com.piseth.java.school.excercise2.json;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class JPage<T> {
	private List<T> items;
	private int page;
	private int pageSize;
	private int totalPage;
	private long totalCount;
	private boolean empty;
	private boolean hasNext;

	public JPage(Page<T> page) {
		this.items = page.getContent();
		this.page = page.getPageable().getPageNumber();
		this.pageSize = page.getPageable().getPageSize();
		this.totalPage = page.getTotalPages();
		this.totalCount = page.getTotalElements();
		this.empty = page.isEmpty();
		this.hasNext = !page.isLast();
	}
}
