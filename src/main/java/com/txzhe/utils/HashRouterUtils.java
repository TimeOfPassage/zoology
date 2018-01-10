package com.txzhe.utils;

public class HashRouterUtils {
	/**
	 * 散列算法 【表散列 - 水平拆分】 散列表每个关键字被映射到0到TableSize-1这个范围中的某个值，这个映射叫做散列函数
	 */
	public static int hash(String key, int tablesize) {
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			// 此处是ASCII值想加
			hashVal = 37 * hashVal + key.charAt(i);
		}
		hashVal = hashVal % tablesize;
		if (hashVal < 0) {
			hashVal += tablesize;
		}
		return hashVal;
	}

	/**
	 * 散列算法 【表散列 - 水平拆分】 散列表每个关键字被映射到0到TableSize-1这个范围中的某个值，这个映射叫做散列函数
	 */
	public static int hash(String key) {
		return hash(key, ConstantsUtils.TABLE_SYSTEM_USER_SIZE);
	}
}
