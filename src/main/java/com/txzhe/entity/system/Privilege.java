package com.txzhe.entity.system;

import java.util.List;

public class Privilege {

	private String id;
	private String name;
	private String icon;
	private String url;
	private int status;

	private List<Privilege> childList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Privilege> getChildList() {
		return childList;
	}

	public void setChildList(List<Privilege> childList) {
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", icon=" + icon + ", url=" + url + ", status=" + status
				+ ", childList=" + childList + "]";
	}
}
