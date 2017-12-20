require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'lib/jquery/jquery',
		'zui' : 'js/zui',
		'datatable' : 'lib/datatable/zui.datatable',
		'metisMenu' : 'extra/metismenu/js/metisMenu'
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
		'zui' : {
			deps : ['jquery'],
			exports : 'zui'
		},
		'datatable' : {
			deps : ['zui'],
			exports : 'datatable'  
		},
		'metisMenu' : {
			deps : ['jquery'],
			exports : 'metisMenu'
		}
	}
});
require(['jquery','zui','datatable','metisMenu'], function ($){
	//初始化菜单
	$("#menu").metisMenu();
	
	/* 初始化数据表格 */
	$('table.datatable').datatable({
		 checkable : true, //显示数据首列的复选框
		 sortable : true,   //开启字段排序功能
		 afterLoad : function(data){
			 console.log("afterLoad 	数据加载完毕后调用");
			 console.log(data.data.rows);
		 }
	});
});