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
<style type="text/css">
a{font-size:16px}   
a:link {text-decoration:none;} //未访问：蓝色、无下划线   
a:visited {text-decoration:none;} //已访问：紫色、无下划线   
</style>
</head>
<body style="padding:0px 30px;">
<!-- 搜索面板start -->
<div class="container bs-docs-container">
	<div class="row" style="padding:20px;">
	  <div class="col-xs-6 col-md-3">
	    <a href="#" class="thumbnail">
	    	<div style="height:140px;width:100%;text-align: center;padding:20px;">
	    		<p>
	    			<i class="glyphicon glyphicon-bitcoin"></i>
	    		</p> 
	    		<p>
	    			<b>65%</b>
	    		</p>
	    		<p>美元$</p>
	    	</div>
	    </a>
	  </div>
	  <div class="col-xs-6 col-md-3">
	    <a href="#" class="thumbnail">
	    	<div style="height:140px;width:100%;text-align: center;padding:20px;">
	    		<p>
	    			<i class="glyphicon glyphicon-bitcoin"></i>
	    		</p> 
	    		<p>
	    			<b>65%</b>
	    		</p>
	    		<p>美元$</p>
	    	</div>
	    </a>
	  </div>
	  <div class="col-xs-6 col-md-3">
	    <a href="#" class="thumbnail">
	    	<div style="height:140px;width:100%;text-align: center;padding:20px;">
	    		<p>
	    			<i class="glyphicon glyphicon-bitcoin"></i>
	    		</p> 
	    		<p>
	    			<b>65%</b>
	    		</p>
	    		<p>美元$</p>
	    	</div>
	    </a>
	  </div>
	  <div class="col-xs-6 col-md-3">
	    <a href="#" class="thumbnail">
	    	<div style="height:140px;width:100%;text-align: center;padding:20px;">
	    		<p>
	    			<i class="glyphicon glyphicon-bitcoin"></i>
	    		</p> 
	    		<p>
	    			<b>65%</b>
	    		</p>
	    		<p>美元$</p>
	    	</div>
	    </a>
	  </div>
	</div>
</div>
<!-- 搜索面板end -->
<script type="text/javascript">
	var baseRoot = "${baseRoot}",basePath = "${basePath}";
</script>
<script type="text/javascript" data-main="${baseRoot}/scripts/form/form.js" src="${baseRoot}/common/lib/requirejs/require.js"></script>
</body>
</html>