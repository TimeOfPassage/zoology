package com.txzhe.controller.api.business.systemApi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.api.AbstractSysApiController;
import com.txzhe.entity.base.DataRow;
import com.txzhe.entity.base.Page;
import com.txzhe.entity.base.ResultSet;
import com.txzhe.entity.system.Privilege;
import com.txzhe.service.system.IPrivilegeService;
import com.txzhe.service.system.impl.PrivilegeServiceImpl;

public class PrivilegeController extends AbstractSysApiController {

	private IPrivilegeService pService;
	
	@Override
	public ResultSet execute(HttpServletRequest request, HttpServletResponse response) {
		ResultSet rs = new ResultSet();
		Page page = new Page();
		DataRow dr = new DataRow();
		//查询系统权限菜单
		pService = new PrivilegeServiceImpl();
		List<Privilege> list = pService.query();
		page.setTotalRecords(pService.queryTotalRows());
		page.setList(list);
		dr.put("rows", page.getList());//所有记录
		dr.put("total", page.getTotalRecords());//分页信息
		return rs;
	}
}
