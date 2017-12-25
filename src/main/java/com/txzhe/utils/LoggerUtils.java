package com.txzhe.utils;

import org.apache.log4j.Logger;

public class LoggerUtils {

	private static Logger logger = Logger.getLogger(LoggerUtils.class);

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void error(String msg) {
		logger.error(msg);
	}
}
