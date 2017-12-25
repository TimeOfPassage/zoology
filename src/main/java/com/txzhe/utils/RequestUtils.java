package com.txzhe.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getCookie(String key, HttpServletRequest req) {
		String value = null;
		if (key == null || "" == key)
			return value;
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (key.equals(cookie.getName())) {
				value =  cookie.getValue();
				break;
			}
		}
		return value;
	}
}
