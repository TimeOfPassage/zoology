require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'base/lib/jquery/1.9.1/jquery.min',
		'layer' : 'base/lib/layer/2.4/layer',
		'hui' : 'base/static/h-ui/js/H-ui',
		'hui-admin-page' : 'base/static/h-ui.admin/js/H-ui.admin.page',
		'WdatePicker' : 'base/lib/My97DatePicker/4.8/WdatePicker',
		'jqueryDataTables' : 'base/lib/datatables/1.10.0/jquery.dataTables.min',
		'laypage' : 'base/lib/laypage/1.2/laypage'
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
			deps : ['layer','jquery']
		},
		'hui-admin-page' : {
			deps : ['layer','hui','jquery']
		},
		'jqueryDataTables' : {
			deps : ['jquery']
		},
		'WdatePicker' : {
			deps : ['jquery']
		},
		'laypage' : {
			deps : ['layer','jquery']
		}
	}
});
require(['jquery','layer','hui','hui-admin-page','laypage','WdatePicker','jqueryDataTables'], function ($,layer){
		
	$(".addArticle").on("click",function(e){
		layer.alert('内容')
		//layer.full(index);
	});

	/*资讯-添加*/
	function article_add(title,url,w,h){
		
	}
	/*资讯-编辑*/
	function article_edit(title,url,id,w,h){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
	/*资讯-删除*/
	function article_del(obj,id){
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type: 'POST',
				url: '',
				dataType: 'json',
				success: function(data){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				},
				error:function(data) {
					console.log(data.msg);
				},
			});		
		});
	}

	/*资讯-审核*/
	function article_shenhe(obj,id){
		layer.confirm('审核文章？', {
			btn: ['通过','不通过','取消'], 
			shade: false,
			closeBtn: 0
		},
		function(){
			$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
			$(obj).remove();
			layer.msg('已发布', {icon:6,time:1000});
		},
		function(){
			$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
			$(obj).remove();
	    	layer.msg('未通过', {icon:5,time:1000});
		});	
	}
	/*资讯-下架*/
	function article_stop(obj,id){
		layer.confirm('确认要下架吗？',function(index){
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
			$(obj).remove();
			layer.msg('已下架!',{icon: 5,time:1000});
		});
	}

	/*资讯-发布*/
	function article_start(obj,id){
		layer.confirm('确认要发布吗？',function(index){
			$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
			$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
			$(obj).remove();
			layer.msg('已发布!',{icon: 6,time:1000});
		});
	}
	/*资讯-申请上线*/
	function article_shenqing(obj,id){
		$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
		$(obj).parents("tr").find(".td-manage").html("");
		layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
	}
});