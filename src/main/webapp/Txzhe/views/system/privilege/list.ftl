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
<!-- DataTables CSS -->
<link href="${baseRoot}/common/lib/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<!-- Custom CSS -->
<link href="${baseRoot}/common/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${baseRoot }/common/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body style="padding:0px 30px;">
<!-- 搜索面板start -->
<div class="panel panel-default" style="margin-top: 20px;">
    <div id="collapseOne" class="panel-collapse collapse in">
    	<div class="panel-heading">
	        <h4 class="panel-title">
	            	权限菜单
	        </h4>
	    </div>
        <div class="panel-body">
        	<form class="form-inline" role="form">
	        	<table class="table" style="margin-bottom: 0px;border:0;" >
	        		<tr>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        		</tr>
	        		<tr>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        			<td>
							<div class="form-group">
						      <label for="name">文章标题:</label>
						      <input type="text" class="form-control" id="name" placeholder="请输入名称">
						    </div>
						</td>
	        		</tr>
	        		<tr>
	        			<td colspan="3" align="right">
							<button class="btn btn-primary" style="margin-right:50px;">Click</button>
						</td>
	        		</tr>
	        	</table>
        	</form>
        </div>
    </div>
    <!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
	            </div>
	            <div class="modal-body">在这里添加一些文本</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" class="btn btn-primary">提交更改</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
</div>
<div class="panel-heading">
    <div class="btn-group">
        <button type="button" class="btn btn-sm btn-info btn-insert-article"  data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 添加</button>
        <button type="button" class="btn btn-sm btn-info"><i class="fa fa-edit"></i> 编辑</button>
        <button type="button" class="btn btn-sm btn-danger"><i class="fa fa-minus"></i>  删除</button>
    </div>
</div>
<div class="panel panel-default">
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
<script type="text/javascript" data-main="${baseRoot}/scripts/system/privilege/list.js" src="${baseRoot}/common/lib/requirejs/require.js"></script>
</body>
</html>