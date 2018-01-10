package com.txzhe.utils;

import java.util.UUID;

/**
 * 常量定义
 * 
 * @author heyangda-bizcent
 */
public class ConstantsUtils {

	/**
	 * 系统用户表水平拆分数
	 */
	public static final int TABLE_SYSTEM_USER_SIZE = 2;

	/**
	 * 作为主键
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
