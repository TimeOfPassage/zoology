package com.txzhe.dao.system.impl;

import java.util.List;

import com.txzhe.dao.base.impl.BaseDaoImpl;
import com.txzhe.dao.system.IUserDao;
import com.txzhe.entity.system.User;
import com.txzhe.utils.ConstantsUtils;
import com.txzhe.utils.HashRouterUtils;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	@Override
	public Integer add(User t) {
		t.setId(ConstantsUtils.getUUID());
		super.TABLE_NAME = "t_system_user_" + HashRouterUtils.hash(t.getId());
		return super.add(t);
	}

	@Override
	public Integer delete(User t) {
		super.TABLE_NAME = "t_system_user_" + HashRouterUtils.hash(t.getId());
		return super.delete(t);
	}

	@Override
	public Integer update(User t) {
		super.TABLE_NAME = "t_system_user_" + HashRouterUtils.hash(t.getId());
		return super.update(t);
	}

	@Override
	public List<User> query() {
		return null;
	}

	@Override
	public Integer queryTotalRows() {
		return null;
	}
}
