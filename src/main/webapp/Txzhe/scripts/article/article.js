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
		url : basePath + "/SysApi",//请求url
		toolbar: '#toolbar',    //工具按钮用哪个容器
		method : 'get',//请求方式
		queryParams : {"id":"article"},//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true
		pagination : true, // 是否显示分页
		sortable : false, // 是否排序
		sidePagination : "server",// 分页方式：client客户端分页，server服务端分页（*）
		//search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		//pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
		queryParamsType : '', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort 
							  // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
		//minimumCountColumns: 2,    //最少允许的列数
		clickToSelect: true,    //是否启用点击选中行
		//contentType: "application/x-www-form-urlencoded", //Post 时使用
		responseHandler:function(res){
			var total = "";
			var rows  = "";
			//console.log(res.data);
			if(typeof(res.data) != "undefined")
			{
			   total = res.data.total
			   rows  = res.data.rows;
			}
			else
			{
				total = res;
				rows  = res;
			}
			var suc = res.errorNo;
			if (suc != 0) {
				return res;
			}
			return {
				"total" : total,// 总页数
				"rows" : rows 
			}
		},
		columns:[
		   {
				 title : '标题',
				 field : 'userName',
				 align : 'center',
				 formatter : function(value){
					 return value;
				 }
		   },
		   {
				 title : '编号',
				 field : 'id',
				 align : 'center',
				 formatter : function(value){
					 return value;
				 }
			 }
		]
    });
	//百度地图相关js异步加载
	$(".btn-insert-article").on("click",function(e){
		  $('#myModal').modal('toggle');
		  initialize();
	});
	
	function initialize(){
		var map = new BMap.Map('map');  
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 11); 
		map.addControl(new BMap.NavigationControl());    
		map.addControl(new BMap.ScaleControl());    
		map.addControl(new BMap.OverviewMapControl());   
		var overlaycomplete = function(e){
			var point = e.overlay.point;
			var lat = point.lat;
			var lng = point.lng;
			$("#lat").val(lat);
			$("#lng").val(lng);
	    };
	    var styleOptions = {
	        strokeColor:"red",    //边线颜色。
	        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
	        strokeWeight: 3,       //边线的宽度，以像素为单位。
	        strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
	        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
	        strokeStyle: 'solid' //边线的样式，solid或dashed。
	    }
	    //实例化鼠标绘制工具
	    var drawingManager = new BMapLib.DrawingManager(map, {
	        isOpen: false, //是否开启绘制模式
	        enableDrawingTool: true, //是否显示工具栏
	        drawingToolOptions: {
	            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
	            offset: new BMap.Size(5, 5), //偏离值
	            drawingModes:[
                  BMAP_DRAWING_MARKER,
                  BMAP_DRAWING_CIRCLE,
                  //BMAP_DRAWING_POLYLINE,
                  //BMAP_DRAWING_POLYGON,
                  BMAP_DRAWING_RECTANGLE 
               ]
	        },
	        circleOptions: styleOptions, //圆的样式
	        rectangleOptions: styleOptions //矩形的样式
	    });  
		 //添加鼠标绘制工具监听事件，用于获取绘制结果
	    drawingManager.addEventListener('overlaycomplete', overlaycomplete);
	}
});