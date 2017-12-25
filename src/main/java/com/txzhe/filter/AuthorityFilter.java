package com.txzhe.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * È¨ÏÞÀ¹½ØÆ÷
 * 
 * @author heyangda-bizcent
 */
public class AuthorityFilter implements Filter {

	private FilterConfig cfg = null;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// »ñÈ¡cookie£¬ÅÐ¶ÏÊÇ·ñµÇÂ¼
		if (!isLogin(request, response))
			return;
		chain.doFilter(req, resp);
	}

	//
	private boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		boolean hasCookie = false;
		for (Cookie cookie : cookies) {
			if ("user".equals(cookie.getName()) && "password".equals(cookie.getValue())) {
				hasCookie = true;
				break;
			}
		}
		return hasCookie;
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		cfg = this.cfg;
	}
}
