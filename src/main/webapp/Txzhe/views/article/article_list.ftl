<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Bootstrap+iframe后台管理系统演示</title>
<!-- Bootstrap Core CSS -->
<link href="${baseRoot}/common/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="${baseRoot}/common/lib/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${baseRoot}/common/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${baseRoot }/common/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Bootstrap-Table CSS -->
<link href="${baseRoot }/common/lib/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" type="text/css">
<!-- Baidu Map CSS -->
<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<style type="text/css">
.form-group-new{margin-right:30px;padding-left:5px;margin-top:10px;}
</style>
</head>
<body style="padding:0px 30px;">
<!-- 搜索面板start -->
<div class="panel panel-default" style="margin-top:30px;">
    <div class="panel-heading">
        <h4 class="panel-title">
            	文章模块
        </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
        <div class="panel-body">
        	<form class="form-inline" role="form">
			  <div class="form-group form-group-new">
			    <label for="name">文章标题:</label>
			    <input type="text" class="form-control" id="name" placeholder="请输入名称">
			  </div>
			  <div class="form-group form-group-new">
			    <label for="name">发布时间:</label>
			    <input type="text" class="form-control" id="name" placeholder="请选择时间">
			  </div>
			  <div class="form-group form-group-new">
			    <label for="name">经度:</label>
			    <input type="text" class="form-control" id="lat"/>
			  </div>
			  <div class="form-group form-group-new">
			    <label for="name">纬度:</label>
			    <input type="text" class="form-control" id="lng">
			  </div>
			  <div class="form-group form-group-new">
				  <button type="button" class="btn btn-primary"><i class="fa fa-search"></i> 搜索</button>
				  <button type="button" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> 清楚条件</button>
			  </div>
			</form>
        </div>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
    	<div class="btn-group">
	        <button type="button" class="btn btn-sm btn-info btn-insert-article"  data-toggle="modal" ><i class="fa fa-plus"></i> 地图</button>
	        <button type="button" class="btn btn-sm btn-info"><i class="fa fa-edit"></i> 编辑</button>
	        <button type="button" class="btn btn-sm btn-danger"><i class="fa fa-minus"></i>  删除</button>
    	</div>
    </div>
    <!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog" style="width:90%">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">确定</button>
	                <h4 class="modal-title" id="myModalLabel">BMap地图调用</h4>
	            </div>
	            <div class="modal-body">
					<div style="width:100%;height:400px;border:#ccc solid 1px;font-size:12px" id="map"></div>
				</div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
    
    <!-- /.panel-heading -->
    <div class="panel-body">
        <div class="dataTable_wrapper">
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
            	
            </table>
        </div>
     </div>
</div>
<!-- 搜索面板end -->
<script type="text/javascript">
	var baseRoot = "${baseRoot}",basePath = "${basePath}";
</script>
<script type="text/javascript" data-main="${baseRoot}/scripts/article/article.js" src="${baseRoot}/common/lib/requirejs/require.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SsAPbFBUnD3WV9IdZ9yxW8gdeSyGXpSW"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
</body>
</html>