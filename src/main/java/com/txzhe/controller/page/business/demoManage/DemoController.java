package com.txzhe.controller.page.business.demoManage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.page.AbstractController;

public class DemoController extends AbstractController {

	@Override
	public Map<String, Object> returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		return new HashMap();
	}

}