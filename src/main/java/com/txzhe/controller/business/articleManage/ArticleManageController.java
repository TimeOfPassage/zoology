package com.txzhe.controller.business.articleManage;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.controller.business.IAbstractController;

/**
 * 跳转 资讯管理-列表
 * 
 * @author heyangda-bizcent
 */
public class ArticleManageController implements IAbstractController {

	public String jumpToPageUrl(String operation) {
		String defaultPath = "views/articleManage/article-list.ftl";
		if ("addArticle".equals(operation)) {
			defaultPath = "views/articleManage/article-add.ftl";
		}
		return defaultPath;
	}

	@Override
	public Map<String, Object> returnMapModel(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Object> map = new HashMap<>();
		String operation = req.getParameter("method");

		return map;
	}
}
