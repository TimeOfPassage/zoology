java生态技术学习

1、freemarker模板引擎技术添加 (初始化freemarker，配置其分享全局变量)

2、整合H.ui页面模板

#启动方式：

目前由于采用添加了权限拦截器，但是还没做登录功能，故当服务启动后，在浏览器开发人员工具的console面板中输入
	
	document.cookie = 'user=password';
	
回车，然后刷新页面即可。

提示：子servlet必须继承FreemarkerServlet，同时重写handlerRedirect和jumpToPageUrl方法