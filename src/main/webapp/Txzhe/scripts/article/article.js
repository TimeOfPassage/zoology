require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'common/lib/jquery/dist/jquery.min',
		'bootstrap' : 'common/lib/bootstrap/dist/js/bootstrap.min',
		'metisMenu' : 'common/lib/metisMenu/dist/metisMenu.min',
		'sb-admin' : 'common/dist/js/sb-admin-2',
		'bootstrapTable' : 'common/lib/bootstrap-table/dist/bootstrap-table',
		'bootstrapTableLocale' : 'common/lib/bootstrap-table/dist/bootstrap-table-local-all'
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
		'bootstrap' : {
			deps : ['jquery'],
			exports : 'bootstrap'
		},
		'metisMenu' : {
			deps : ['jquery'],
			exports : 'metisMenu'
		},
		'sb-admin' : {
			deps : ['jquery']
		},	
		'bootstrapTable' : {
			deps : ['jquery']
		},
		'bootstrapTableLocale' : {
			deps : ['jquery']
		}
	}
});
require(['jquery','metisMenu','bootstrap','sb-admin','bootstrapTable'], function ($){
	//-左边菜单控制切换右侧内容js-
	$('#dataTables-example').bootstrapTable({
		url : basePath + "/",//请求url
		method : 'get',//请求方式
		queryParams : {"id":"1"},// 传递参数
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true
		pagination : true, // 是否显示分页
		sortable : true, // 是否排序
		sidePagination : "server",// 服务端分页
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		responseHandler:function(res){
			var total = "";
			var rows  = "";
			//console.log(res.data);
			if(typeof(res.data) != "undefined")
			{
			   total = res.data.pageCond.count;
			   rows  = res.data.list;
			}
			else
			{
				total = res;
				rows  = res;
			}
			var suc = res.code;
			if (suc != 1) {
				return res;
			}
			return {
				"total" : total,// 总页数
				"rows" : rows 
			}
		},
		columns:[
		   {
				 //第一列
				 title : '标题',
				 field : 'userName',
				 align : 'center',
				 formatter : function(value){
					 return value;
				 }
		   },
		   {
				 //第二列
				 title : '评论时间',
				 field : 'createTime',
				 align : 'center',
				 formatter : function(value){
					 if (value) {
							return formatDate(value);
						}
						return '-';
				 }
			 }
		]
    });
	
	//提交
	$("#submit_article").on("click",function(e){
		
	});
});