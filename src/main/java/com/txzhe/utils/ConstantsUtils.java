package com.txzhe.utils;

import java.util.UUID;

/**
 * ��������
 * 
 * @author heyangda-bizcent
 */
public class ConstantsUtils {

	/**
	 * ϵͳ�û���ˮƽ�����
	 */
	public static final int TABLE_SYSTEM_USER_SIZE = 2;

	/**
	 * ��Ϊ����
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
