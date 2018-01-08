package com.txzhe.service.system.impl;

import java.util.List;

import com.txzhe.dao.system.IPrivilegeDao;
import com.txzhe.dao.system.impl.PrivilegeDaoImpl;
import com.txzhe.entity.system.Privilege;
import com.txzhe.service.system.IPrivilegeService;

public class PrivilegeServiceImpl implements IPrivilegeService {

	private IPrivilegeDao pDao;
	
	public PrivilegeServiceImpl() {
		pDao = new PrivilegeDaoImpl();
	}
	
	
	@Override
	public List<Privilege> query() {
		return pDao.query();
	}

	@Override
	public int queryTotalRows() {
		// TODO Auto-generated method stub
		return pDao.queryTotalRows();
	}

}
