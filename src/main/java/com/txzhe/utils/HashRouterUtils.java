package com.txzhe.utils;

public class HashRouterUtils {
	/**
	 * ɢ���㷨 ����ɢ�� - ˮƽ��֡� ɢ�б�ÿ���ؼ��ֱ�ӳ�䵽0��TableSize-1�����Χ�е�ĳ��ֵ�����ӳ�����ɢ�к���
	 */
	public static int hash(String key, int tablesize) {
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			// �˴���ASCIIֵ���
			hashVal = 37 * hashVal + key.charAt(i);
		}
		hashVal = hashVal % tablesize;
		if (hashVal < 0) {
			hashVal += tablesize;
		}
		return hashVal;
	}

	/**
	 * ɢ���㷨 ����ɢ�� - ˮƽ��֡� ɢ�б�ÿ���ؼ��ֱ�ӳ�䵽0��TableSize-1�����Χ�е�ĳ��ֵ�����ӳ�����ɢ�к���
	 */
	public static int hash(String key) {
		return hash(key, ConstantsUtils.TABLE_SYSTEM_USER_SIZE);
	}
}
