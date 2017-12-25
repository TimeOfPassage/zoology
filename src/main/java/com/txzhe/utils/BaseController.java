package com.txzhe.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.txzhe.controller.api.AbstractSysApiController;
import com.txzhe.controller.page.AbstractController;

@SuppressWarnings("unused")

public class BaseController<T> {

	private static Logger logger = Logger.getLogger(BaseController.class);

	private static Map<String, AbstractController> classNameByPageSuperClass = null;

	private static Map<String, AbstractSysApiController> classNameByAPISuperClass = null;

	static {
		classNameByPageSuperClass = getClassNameByInterface();
		classNameByAPISuperClass = getSysAPIClassNameByInterface();
	}

	/**
	 * @return 根据接口获取其所有实现类对象
	 */
	private static Map<String, AbstractController> getClassNameByInterface() {
		String packageName = AbstractController.class.getPackage().getName();
		String path = packageName.replace(".", "/");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(path);
		File dir = new File(url.getFile());
		return getClasses(dir, packageName);

	}

	private static Map<String, AbstractSysApiController> getSysAPIClassNameByInterface() {
		String packageName = AbstractSysApiController.class.getPackage().getName();
		String path = packageName.replace(".", "/");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(path);
		File dir = new File(url.getFile());
		return getApiClasses(dir, packageName);

	}

	private static Map<String, AbstractSysApiController> getApiClasses(File dir, String packageName) {
		Map<String, AbstractSysApiController> classesMap = new HashMap<>();
		if (!dir.exists()) {
			logger.warn("业务包内不存在" + dir.getAbsoluteFile());
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				// 递归迭代
				classesMap.putAll(getApiClasses(f, packageName + "." + f.getName()));
			}
			String fileName = f.getName();
			if (fileName.endsWith(".class") && !fileName.contains(AbstractSysApiController.class.getSimpleName())) {
				String pkName = fileName.substring(0, fileName.length() - 6);
				String wipeSuffixClassName = pkName.substring(0, pkName.length() - 10).toLowerCase();
				String classPath = packageName + "." + pkName;
				try {
					classesMap.put(wipeSuffixClassName,
							(AbstractSysApiController) Class.forName(classPath).newInstance());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					logger.error(fileName + "未找到", e);
				} catch (InstantiationException e) {
					e.printStackTrace();
					logger.error("实例化类异常", e);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					logger.error("实例化类异常", e);
				}
			}
		}
		return classesMap;
	}

	/**
	 * 从dir下获取所有classes对象
	 * 
	 * @param <T>
	 * 
	 * @param dir
	 *            目录
	 * @param packageName
	 *            包名
	 * @param classes
	 *            类的实例
	 */
	private static Map<String, AbstractController> getClasses(File dir, String packageName) {
		Map<String, AbstractController> classesMap = new HashMap<>();
		if (!dir.exists()) {
			logger.warn("业务包内不存在" + dir.getAbsoluteFile());
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				// 递归迭代
				classesMap.putAll(getClasses(f, packageName + "." + f.getName()));
			}
			String fileName = f.getName();
			if (fileName.endsWith(".class") && !fileName.contains(AbstractController.class.getSimpleName())) {
				String pkName = fileName.substring(0, fileName.length() - 6);
				String wipeSuffixClassName = pkName.substring(0, pkName.length() - 10).toLowerCase();
				String classPath = packageName + "." + pkName;
				try {
					classesMap.put(wipeSuffixClassName, (AbstractController) Class.forName(classPath).newInstance());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					logger.error(fileName + "未找到", e);
				} catch (InstantiationException e) {
					e.printStackTrace();
					logger.error("实例化类异常", e);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					logger.error("实例化类异常", e);
				}
			}
		}
		return classesMap;
	}

	public static void main(String[] args) {
		// System.out.println(AbstractSysApiController.class.getPackage().getName());
	}

	/**
	 * 核心控制分发 identity 实现类唯一id
	 */
	public static AbstractController sysCoreControl(String identity) {
		// 遍历某包下所有controller实现类
		return classNameByPageSuperClass.get(identity);
	}

	/**
	 * 核心控制分发 identity 实现类唯一id
	 */
	public static AbstractSysApiController sysApiCoreControl(String identity) {
		// 遍历某包下所有controller实现类
		return classNameByAPISuperClass.get(identity);
	}

}
