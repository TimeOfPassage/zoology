package com.txzhe.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.entity.base.ResultSet;

public abstract class AbstractSysApiController {

	public abstract ResultSet execute(HttpServletRequest request, HttpServletResponse response);

}
