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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>日常事务管理系统用户注册</title>
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.min.css">
<link href="css/bootstrap-datetimepicker.css" rel="stylesheet">
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li><a href="#">主&nbsp;&nbsp;页</a></li>
					<li><a href="#">消息查看</a></li>
					<li><a href="#">消息回复</a></li>
					<li class="active"><a href="#">用户注册</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">日常事务管理系统用户登录</h3>
		</div>

		<div class="jumbotron">
			<form class="form-signin" action="user?option=2" method="post">
				<h2 class="form-signin-heading">用户注册</h2><br /> 
				<input type="text" name="username" class="form-control"placeholder="用户名" required="" autofocus=""> <br /> 
				<input type="password" name="password" class="form-control" placeholder="密码" required=""><br/>
				<label class="radio-inline">  <input type="radio" name="usersex"  value="1" checked="checked"> 男 </label>
				<label class="radio-inline"> <input type="radio" name="usersex"  value="2"> 女 </label> <br/><br/>
				<input type="text" name="phonenumber" class="form-control"placeholder="电话号码" required="" autofocus=""> <br /> 
				<input type="text" name="userplace" class="form-control"placeholder="居住地" required="" autofocus=""> <br /> 
				<div class="input-group date" name="userbirthday" id="userbirthday">
					<input type="text" name="userbirthday" class="form-control">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                <br/>
				<button type="submit"class="btn btn-info btn-lg btn-primary btn-block">注册</button>
			</form>
		</div>
		<footer class="footer">
		<p>© Company 2015</p>
		</footer>

	</div>
	<!-- /container -->

</body>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/moment-with-locales.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript">
	$(function () {
		$('#userbirthday').datetimepicker();
	});
</script>
</html>
