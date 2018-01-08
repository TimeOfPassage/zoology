package com.txzhe.service.system;

import java.util.List;

import com.txzhe.entity.system.Privilege;

public interface IPrivilegeService {

	List<Privilege> query();

	int queryTotalRows();

}
