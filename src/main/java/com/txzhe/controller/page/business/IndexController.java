package com.txzhe.controller.page.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.page.AbstractController;
import com.txzhe.dao.system.IPrivilegeDao;
import com.txzhe.dao.system.impl.PrivilegeDaoImpl;
import com.txzhe.entity.base.DataRow;
import com.txzhe.entity.system.Privilege;
import com.txzhe.utils.LoggerUtils;
import com.txzhe.utils.RequestUtils;

public class IndexController extends AbstractController{

	@Override
	public DataRow returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		LoggerUtils.info("index controller start");
		
		String userId= RequestUtils.getCookie("userId", req);
		IPrivilegeDao pDao = new PrivilegeDaoImpl();
		userId = "1";
		List<Privilege> privilegeList = pDao.queryPrivilegeListByUserId(userId);
		//
		//DataRow item = new DataRow();
		
		for (Privilege p : privilegeList) {
			System.out.println(p);
		}
		LoggerUtils.info("index controller end");
		return null;
	}
}
