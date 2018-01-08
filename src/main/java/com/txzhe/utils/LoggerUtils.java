package com.txzhe.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class LoggerUtils {

	private static Logger logger = Logger.getLogger(LoggerUtils.class);

	public static void info(Object obj) {
		try {
			/*** 获取输出信息的代码的位置 ***/
			String location = "";
			StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
//			logger.info("----------------------------------------------");
//			for (int i = 0; i < stacks.length; i++) {
//				System.out.println(stacks[i]);
//			}
//			logger.info("----------------------------------------------");
			location = "["+stacks[2].getClassName()+"] ";
			/*** 是否是异常 ***/
			if (obj instanceof Exception) {
				Exception e = (Exception) obj;
				StringWriter sw = new StringWriter();
				e.printStackTrace(new PrintWriter(sw, true));
				String str = sw.toString();
				logger.info(location + str);
			} else {
				logger.info(location + obj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void error(String msg) {
		logger.error(msg);
	}
}
