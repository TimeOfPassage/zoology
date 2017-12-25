package com.txzhe.entity.base;

import java.util.List;

public class Page {

	// ×Ü¼ÇÂ¼Êý
	private int totalRecords;
	// List
	private List<Object> list;

	public Page() {
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

}
