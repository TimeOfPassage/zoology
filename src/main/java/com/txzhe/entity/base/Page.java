package com.txzhe.entity.base;

import java.util.List;

public class Page<T> {

	// ×Ü¼ÇÂ¼Êý
	private int totalRecords;
	// List
	private List<T> list;

	public Page() {
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
