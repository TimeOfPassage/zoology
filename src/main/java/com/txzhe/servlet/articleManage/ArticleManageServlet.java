package com.txzhe.servlet.articleManage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.txzhe.servlet.FreemarkerServlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 跳转 资讯管理-列表
 * @author heyangda-bizcent
 */
public class ArticleManageServlet extends FreemarkerServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 使用模板文件的Charset作为本页面的charset
		// 使用text/html MIME-type
		response.setContentType("text/html; charset=" + template.getEncoding());
		Map<String, Object> dataModel = new HashMap<String, Object>();
		dataModel.put("toRouter", "views/articleManage/article-list.ftl");
		try {
			template.process(dataModel, response.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
	}
}
