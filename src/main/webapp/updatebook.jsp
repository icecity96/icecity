<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Icecity BMS</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
				<h1 style="text-align: center">Update New Book</h1>
				<form action="updatebook" method="post">
				<div class="form-group" style="width:800px; margin:0 auto;">
					<label class="col-sm-3 control-label">ISBN：</label>
					<div class="col-sm-9">
						<input type="text" name="isbn" class="form-control">
					</div>
				</div>
				<div class="form-group" style="width:800px; margin:0 auto;">
					<label class="col-sm-3 control-label">出版社：</label>
					<div class="col-sm-9">
						<input type="text" name="publisher" class="form-control">
					</div>
				</div>
				<div class="form-group" style="width:800px; margin:0 auto;">
					<label class="col-sm-3 control-label">出版日期：</label>
					<div class="col-sm-9">
						<input type="date" name="publishdate" class="form-control">
					</div>
				</div>
				<div class="form-group" style="width:800px; margin:0 auto;">
					<label class="col-sm-3 control-label">价格：</label>
					<div class="col-sm-9">
						<input type="number" step="0.01" name="price" class="form-control">
					</div>
				</div>
				<div class="form-group" style="width:800px; margin:0 auto;">
					<label class="col-sm-3 control-label">作者ID：</label>
					<div class="col-sm-9">
						<input type="text" name="authorid" class="form-control">
				</div>
				<div style="text-align: center">
					<button class="btn btn-primary " type="submit"><i class="fa fa-check"></i>&nbsp;Add</button>
				</div>
				</div>
				</form>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
