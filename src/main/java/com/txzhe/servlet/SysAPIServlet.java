package com.txzhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.txzhe.controller.api.AbstractSysApiController;
import com.txzhe.entity.base.ResultSet;
import com.txzhe.utils.BaseController;

/**
 * 系统调度器
 * 
 * @author heyangda-bizcent
 */
public class SysAPIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(SysAPIServlet.class);

	@Override
	public void init() throws ServletException {
		logger.info("System API init ...");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		// 后期做个get\post方法过滤
		ResultSet rs = null;
		String prefix = request.getParameter("id");
		if (prefix == null) {
			rs = new ResultSet();
			rs.setErrorNo("-2");
			rs.setErrorMessage("系统异常," + prefix + "对应处理器为空！");
			rs.setData(new HashMap<Object, Object>());
			writeJSON(response, rs);
			return;
		}
		AbstractSysApiController api = BaseController.sysApiCoreControl(prefix);
		if (api == null) {
			rs = new ResultSet();
			rs.setErrorNo("-1");
			rs.setErrorMessage("系统异常");
			rs.setData(new HashMap<Object, Object>());
			writeJSON(response, rs);
			return;
		}
		rs = api.execute(request, response);
		if (rs == null) {
			rs = new ResultSet();
			rs.setData(new HashMap<Object, Object>());
			logger.warn("结果集为空，请确认");
		}
		writeJSON(response, rs);
	}

	public static void main(String[] args) {
		ResultSet rs = new ResultSet();
		rs.setData(new HashMap<Object, Object>());
		System.out.println(JSON.toJSON(rs));
	}

	/**
	 * 将内容以json格式输出
	 */
	private void writeJSON(HttpServletResponse response, ResultSet rs) {
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		try {
			// 设置输出编码
			out = response.getWriter();
			out.write(JSON.toJSONString(rs));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("输出数据出错!", e);
		}
	}

	@Override
	public void destroy() {
		logger.info("System API destory...");
	}
}
