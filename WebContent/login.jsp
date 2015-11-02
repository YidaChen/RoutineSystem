<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>日常事务管理系统-用户登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<!-- Custom styles for this template -->
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<%@ include file="include/header.jsp"%>

		<div class="jumbotron">
			<form class="form-signin" action="user_1.html" method="post">
				<h2 class="form-signin-heading">用户登录</h2><br /> 
				<input type="text" name="username" class="form-control"placeholder="用户名" required="" autofocus=""> <br /> 
				<input type="password" name="password" class="form-control" placeholder="密码" required="">
				<div class="row">
					<div class="col-lg-6">
						<a href="register.html"><button type="button"class="btn btn-info btn-lg btn-primary btn-block">注册</button></a>
					</div>

					<div class="col-lg-6">
						<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
					</div>
				</div>
			</form>
		</div>
		<footer class="footer">
		<p>© Company 2015</p>
		</footer>

	</div>
	<!-- /container -->

</body>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-1.9.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</html>
