package com.txzhe.dao.system;

import java.util.List;

import com.txzhe.dao.base.IBaseDao;
import com.txzhe.entity.system.Privilege;

public interface IPrivilegeDao extends IBaseDao<Privilege> {

	List<Privilege> queryPrivilegeListByUserId(String userId);

}
