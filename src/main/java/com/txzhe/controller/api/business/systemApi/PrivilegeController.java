package com.txzhe.controller.api.business.systemApi;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.txzhe.controller.api.AbstractSysApiController;
import com.txzhe.dao.system.IPrivilegeDao;
import com.txzhe.dao.system.impl.PrivilegeDaoImpl;
import com.txzhe.entity.base.DataRow;
import com.txzhe.entity.base.ResultSet;
import com.txzhe.entity.system.Privilege;
import com.txzhe.utils.LoggerUtils;
import com.txzhe.utils.RequestUtils;

public class PrivilegeController extends AbstractSysApiController {

	private List<Object> sonTree;
	@Override
	public ResultSet execute(HttpServletRequest request, HttpServletResponse response) {
		LoggerUtils.info("Privilege controller start");
		sonTree = new ArrayList<>();
		String userId = RequestUtils.getCookie("userId", request);
		IPrivilegeDao pDao = new PrivilegeDaoImpl();
		userId = "bca1acfeb2034cf3a595f06a77da7952";
		List<Privilege> privilegeList = pDao.queryPrivilegeListByUserId(userId);
		//无限极分类 子孙树 https://www.jianshu.com/p/ff07b46666c7
		getSubTree(privilegeList,"0",0);
		DataRow dr = new DataRow();
		dr.put("treeList", sonTree);
		ResultSet rs = new ResultSet();
		rs.setData(dr);
		rs.setErrorMessage("调用成功");
		rs.setErrorNo("0");
		LoggerUtils.info("Privilege controller end");
		return rs;
	}
	
	/**
	 * 获取完整的树
	 * @param privilegeList 待分类数据
	 * @param 父ID
	 * @param 节点等级
	 * @return 完整树
	 */
	private void getSubTree(List<Privilege> privilegeList, String parentId, int level) {
		
		for (Privilege privilege : privilegeList) {
			if(parentId.equals(privilege.getParentId())){
				privilege.setSort(level);
				sonTree.add(JSON.toJSONString(privilege));
				getSubTree(privilegeList, privilege.getId(), level+1);
			}
		}
	}
}
