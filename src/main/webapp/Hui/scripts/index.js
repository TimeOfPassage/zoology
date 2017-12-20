require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'base/lib/jquery/1.9.1/jquery.min',
		'layer' : 'base/lib/layer/2.4/layer',
		'hui' : 'base/static/h-ui/js/H-ui',
		'hui-admin-page' : 'base/static/h-ui.admin/js/H-ui.admin.page'
	},
	//加载非规范的模块
	//1、这样的模块在用require()加载之前，要先用require.config()方法，定义它们的一些特征
	//2、要加载它们的话，必须先定义它们的特征。
	
	//注意点：
	//1、exports值(输出的变量名)，表明这个模块外部调用时的名称
	//2、deps数组，表明该模块的依赖性
	shim : {
		'jquery' : {
			exports : 'jquery'  
		},
		'layer' : {
			deps : ['jquery'],
			exports : 'layer'
		},
		'hui' : {
			deps : ['jquery','layer'],
			exports : 'hui'  
		},
		'hui-admin-page' : {
			deps : ['jquery','layer','hui'],
			exports : 'hui-admin-page'
		}
	}
});
require(['jquery','layer','hui','hui-admin-page'], function ($,layer){
	$("#loginNum").text(200);
});
	