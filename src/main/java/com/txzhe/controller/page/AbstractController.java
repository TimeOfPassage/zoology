package com.txzhe.controller.page;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.utils.PropertiesUtils;

public abstract class AbstractController {
	public String jumpToPageUrl(String operation) {
		return PropertiesUtils.getPageUrlById(operation);
	}

	public abstract Map<String, Object> returnMapModel(HttpServletRequest req, HttpServletResponse resp);
}
