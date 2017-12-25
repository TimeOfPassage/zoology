package com.txzhe.controller.page.business.demoManage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.page.AbstractController;
import com.txzhe.entity.base.DataRow;

public class DemoController extends AbstractController {

	@Override
	public DataRow returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		return new DataRow();
	}

}
