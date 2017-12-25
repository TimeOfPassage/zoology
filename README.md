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
	4. 在business下建立相应的XXXController，必须建立在business目录下(AbstractController同级目录);
	         其中XXX必须和id的值一致(不区分大小写，建议驼峰命名)。
	5. 让XXXController继承AbstractController类，并实现returnMapModel方法(此处是返回值是页面需要的数据)
	6. 在controller中调用service，则需要在对应的包下建立service和其impl实现
	7. 在service中调用dao，框架实现了基本通用的dao，所以建立Dao时要让自定义的dao接口继承IBaseDao接口，同时指定泛型；
	         实现dao接口时，同样要继承BaseDaoImpl，并填上泛型。
	8. 定义实体时，必须建立在com.txzhe.entity包下，**实体中字段必须和数据库表字段一致**；
	          数据库表名命名规则：t_packageName_entityName
	         其中packageName指com.txzhe.entity包后级及其子目录

#### 调试运行

	1. 通过tomcat部署服务并启动tomcat
	
	2. 打开浏览器访问：http://ip:port/zoology/SysTracker?id=form&&method=form_list(单页面调试)
	3. 打开浏览器访问：http://ip:port/zoology(页面整合调试)
	
	注意：因为有权限拦截，所以2,3两步方式后默认显示空白，这时需要通过F12开发人员，在console面板中输入：
	
		document.cookie = 'user=password';
	
	然后回车，刷新页面。
	