package com.txzhe.dao.base;

import java.util.List;

public interface IBaseDao<T> {

	Integer add(T t);
	
	Integer delete(T t);
	
	Integer update(T t);
	
	List<T> query();
}
