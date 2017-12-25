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
		'datatables' : 'common/lib/datatables/media/js/jquery.dataTables.min',
		'bootstrapDataTables' : 'common/lib/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min'
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
		'datatables' : {
			deps : ['jquery'],
			exports : 'datatables'
		},		
		'bootstrapDataTables' : {
			deps : ['jquery','datatables']
		}
	}
});
require(['jquery','bootstrap','metisMenu','sb-admin','datatables','bootstrapDataTables'], function ($){
	//-左边菜单控制切换右侧内容js-
	$('#dataTables-example').DataTable({
    	"responsive": true,
    	"bLengthChange" : true, //是否显示每页大小下拉框
    	"bFilter" : false //是否启用客户端过滤
    });
});