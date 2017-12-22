#### java生态技术学习之后台网站搭建

1、freemarker模板引擎技术添加 (初始化freemarker，配置其分享全局变量)

#### 开发步骤

	1. 在views/index.ftl中添加左边子菜单项
	2. 在views和scripts下建立对应子菜单页面
	3. 在src/main/resources的page.config.properties中配置页面method对应页面
		
			注意：文件中key必须请求url中的method值一致
			
			例如：请求 ${basePath}/SysTracker?id=form&method=form_list
				   那么文件中配置应该如下：
					form_list=views/form/form.ftl
	4. 在business下建立相应的XXXController，必须建立在business目录下(AbstractController同级目录)。
	5. 让XXXController继承AbstractController类，并实现returnMapModel方法(此处是返回值是页面需要的数据)

#### 调试运行

	1. 通过tomcat部署服务并启动tomcat
	
	2. 打开浏览器访问：http://ip:port/zoology/SysTracker?id=form&&method=form_list(单页面调试)
	3. 打开浏览器访问：http://ip:port/zoology(页面整合调试)
	
	注意：因为有权限拦截，所以2,3两步方式后默认显示空白，这时需要通过F12开发人员，在console面板中输入：
	
		document.cookie = 'user=password';
	
	然后回车，刷新页面。
	