package com.txzhe.controller.business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAbstractController {
	public String jumpToPageUrl(String operation);

	public Map<String, Object> returnMapModel(HttpServletRequest req, HttpServletResponse resp);
}
