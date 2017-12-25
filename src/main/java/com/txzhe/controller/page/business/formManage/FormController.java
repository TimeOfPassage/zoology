package com.txzhe.controller.page.business.formManage;

import java.util.ArrayList;
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

/**
 * 跳转 资讯管理-列表
 * 
 * @author heyangda-bizcent
 */
public class FormController extends AbstractController {

	public static final Integer ENABLE = 1;
	public static final Integer DISABLE = 0;

	@Override
	public DataRow returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		LoggerUtils.info("FormController start");

		String userId = RequestUtils.getCookie("userId", req);
		IPrivilegeDao pDao = new PrivilegeDaoImpl();
		userId = "1";
		List<Privilege> privilegeList = pDao.queryPrivilegeListByUserId(userId);
		// 后期添加菜单分类，从菜单中获取级数
		DataRow firstLevel= null;
		DataRow secondLevel = null;
		DataRow thirdLevel = null;
		List<DataRow> firstLevelList = new ArrayList<>();
		List<DataRow> secondLevelList = new ArrayList<>();
		List<DataRow> thirdLevelList = new ArrayList<>();
		for (Privilege p : privilegeList) {
			if (ENABLE == p.getStatus()) {// 菜单启用
				if ("0".equals(p.getParentId())) {
					// 一级列表
					firstLevel= new DataRow();
					firstLevel.put("url", p.getUrl());
					firstLevel.put("menu_name", p.getName());
					firstLevel.put("icon", p.getIcon());
					firstLevelList.add(firstLevel);
				} else if ("1".equals(p.getParentId())) {
					secondLevel = new DataRow();
					secondLevel.put("url", p.getUrl());
					secondLevel.put("menu_name", p.getName());
					secondLevel.put("icon", p.getIcon());
					secondLevelList.add(secondLevel);
				} else {
					thirdLevel = new DataRow();
					thirdLevel.put("url", p.getUrl());
					thirdLevel.put("menu_name", p.getName());
					thirdLevel.put("icon", p.getIcon());
					thirdLevelList.add(thirdLevel);
				}
			}
		}
		DataRow returnDr = new DataRow();
		returnDr.put("oneLevel", firstLevelList);
		returnDr.put("twoLevel", secondLevelList);
		returnDr.put("threeLevel", thirdLevelList);
		LoggerUtils.info("FormController end");
		return returnDr;
	}
}
