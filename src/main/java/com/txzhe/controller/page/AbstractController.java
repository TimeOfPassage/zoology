package com.txzhe.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.entity.base.DataRow;
import com.txzhe.utils.PropertiesUtils;

public abstract class AbstractController {
	public String jumpToPageUrl(String operation) {
		return PropertiesUtils.getPageUrlById(operation);
	}

	public abstract DataRow returnMapModel(HttpServletRequest req, HttpServletResponse resp);
}
