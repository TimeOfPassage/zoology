package com.txzhe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.txzhe.servlet.SysTrackerServlet;

/**
 * properties属性文件工具类
 * 
 * @author heyangda-bizcent
 */
public class PropertiesUtils {

	private static Logger logger = Logger.getLogger(PropertiesUtils.class);
	/**
	 * freemarker.config.properties define area
	 */
	private final static String FREEMARKER_FILENAME = "freemarker.config.properties";
	private final static String FREEMARKER_SETTING_PRIFIX = "settings.";
	private final static String FREEMARKER_VARIABLES_PRIFIX = "variables.";
	// freemarker
	// setting Map
	// variables Map
	public static Map<String, Properties> freemarkerMap = new HashMap<String, Properties>();

	/**
	 * page.config.properties define area
	 */
	private final static String PAGE_CONFIG = "page.config.properties";
	private static Map<String, String> pageUrlMap = new HashMap<String, String>();

	static {
		// 1、加载freemarker
		InputStream inputStream = PropertiesUtils.class.getResourceAsStream("/" + FREEMARKER_FILENAME);
		Properties props = new Properties();
		try {
			props.load(inputStream);
			// settings
			Enumeration<Object> keys = props.keys();
			Properties settingProp = new Properties();
			Properties variablesProp = new Properties();
			while (keys.hasMoreElements()) {
				String record = keys.nextElement().toString();
				String value = props.getProperty(record);
				if (record.startsWith(FREEMARKER_SETTING_PRIFIX)) {
					settingProp.put(record.replace(FREEMARKER_SETTING_PRIFIX, ""), value);
				} else if (record.startsWith(FREEMARKER_VARIABLES_PRIFIX)) {
					variablesProp.put(record.replace(FREEMARKER_VARIABLES_PRIFIX, ""), value);
				}
			}
			freemarkerMap.put("settings", settingProp);
			freemarkerMap.put("variables", variablesProp);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("加载配置文件:" + FREEMARKER_FILENAME + "异常，请检查！", e);
		}
		// 2、加载page.config.properties
		inputStream = PropertiesUtils.class.getResourceAsStream("/" + PAGE_CONFIG);
		props = new Properties();
		try {
			props.load(inputStream);
			Enumeration<Object> keys = props.keys();
			while (keys.hasMoreElements()) {
				String record = keys.nextElement().toString();
				String value = props.getProperty(record);
				pageUrlMap.put(record, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("加载配置文件:" + PAGE_CONFIG + "异常，请检查！", e);
		}
	}

	/**
	 * 根据id获取页面url
	 * 
	 * @param operation
	 *            前端传入operation
	 * @return
	 */
	public static String getPageUrlById(String operation) {
		return pageUrlMap.get(operation);
	}
}
