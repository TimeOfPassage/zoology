require.config({
	// 默认情况下模块所在目录为js/lib
	baseUrl : baseRoot,
	// 当模块id前缀为app时，他便由js/app加载模块文件
	// 这里设置的路径是相对与baseUrl的，不要包含.js
	paths: {
		'jquery' : 'common/lib/jquery/dist/jquery.min',
		'ztree' : 'common/lib/zTree_v3/js/jquery.ztree.core',
		'ztreeExcheck' : 'common/lib/zTree_v3/js/jquery.ztree.excheck',
		'ztreeExedit' : 'common/lib/zTree_v3/js/jquery.ztree.exedit'
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
		'ztree' : {
			deps : ['jquery'],
			exports : 'ztree'
		},
		'ztreeExcheck' : {
			deps : ['jquery','ztree'],
			exports : 'ztreeExcheck'
		},
		'ztreeExedit' : {
			deps : ['jquery','ztree'],
			exports : 'ztreeExedit'
		},
	}
});
require(['jquery','ztree','ztreeExcheck','ztreeExedit'], function ($){
	var setting = {
	    view: {
            selectedMulti: false
        },
        check: {
            enable: true,
            chkStyle: 'checkbox',
            radioType: "level"
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        async: {
        	url:basePath + "/SysApi",
        	autoParam: [""],
        	otherParam: {"id":"privilege"},
        	type:"get",
        	enable:true
        },
        callback: {
			onAsyncSuccess: onAsyncSuccess,
			onAsyncError: onAsyncError
		}
    };
	function onAsyncSuccess(e,treeId,treeNode,msg){
		var msgObj = eval('('+msg+')');
		//msgObj.data.treeList
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		totalCount = treeNode.count;
		treeNode.icon = "";
		zTree.updateNode(treeNode);
		zTree.selectNode(treeNode.children[0]);
	}
	function onAsyncError(e,treeId,treeNode,XMLHttpRequest,textStatus,errorThrown){
		alert(XMLHttpRequest);
	}
	var zNodes =[
	             { id:1, pId:0, name:"pNode 1"},
	             { id:11, pId:1, name:"pNode 11"},
	             { id:111, pId:11, name:" sNode 111"},
	             { id:12, pId:1, name:"pNode 12"},
	             { id:121, pId:12, name:"sNode 121"},
	             { id:13, pId:1, name:"pNode 13"},
	             { id:2, pId:0, name:"pNode 2"},
	         ];
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting);
	});
	
	
	
	//展开所有节点
	//$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
});