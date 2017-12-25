require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'common/lib/jquery/dist/jquery.min',
		'bootstrap' : 'common/lib/bootstrap/dist/js/bootstrap.min',
		'metisMenu' : 'common/lib/metisMenu/dist/metisMenu.min',
		'sb-admin' : 'common/dist/js/sb-admin-2'
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
		}
	}
});
require(['jquery','bootstrap','metisMenu','sb-admin'], function ($){
	//-左边菜单控制切换右侧内容js-
	$(".menuc").click(function(){
		var url = $(this).attr("url");
		console.log(url);
		$("#iframecon").attr("src",url); 
	});
	setHeight();
	//自适应iframe高度
	function setHeight()
	{
		var ht = $(window).height();//获取浏览器窗口的整体高度；
	    var topHeader = $(".navbar-static-top").height();//获取头部高度，定义一个变量名为topHeader
	    $(".sidebar").height(ht);
	    $("#iframecon").height(ht);
	    $(".sidebar").height(ht-topHeader);//计算左边高度：窗口高度-头部高度
	    $("#iframecon").height(ht-topHeader);//计算右边高度：窗口高度-头部高度
	}
});