<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日常事务管理系统-管理员管理</title>
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.min.css">
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li><a href="index.html">主&nbsp;&nbsp;页</a></li>
					<c:choose>
						<c:when test="${sessionScope.userstatus!=null}">
							<c:choose>
								<c:when test="${sessionScope.userstatus.isAdmin==1}">
									<li><a href="manage_1.html">消息管理</a></li>
									<li><a href="manage.html">用户管理</a></li>
									<li><a href=".html">批复管理</a></li>
									<li><a href="#">${sessionScope.userstatus.userName}</a></li>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
							<!-- 无权限操作未登录 -->
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<h3 class="text-muted">日常事务管理系统管理界面</h3>
		</div>
		<div class="jumbotron">
			<table class="table table-bordered">
				<tr>
					<td>编号</td>
					<td>用户名</td>
					<td>性别</td>
					<td>电话号码</td>
					<td>出生地</td>
					<td>注册时间</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${userlist}" var="user">
					<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.userSex}</td>
					<td>${user.userPhoneNumber}</td>
					<td>${user.userPlace}</td>
					<td>${user.joinTime}</td>
					<td>${user.status}</td>
					<td><a href="manage_5_${user.userId}.html">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<ul class="pager">
			<c:choose>
				<c:when test="${page!=null}">
					<c:choose>
				       	<c:when test="${page.index==1}">
							<li class="disabled"><a href="#">&larr;上一页</a></li>
				       	</c:when>              
				           <c:otherwise>
				           	<li><a href="manage_0_10_${page.index-1}.html">&larr;上一页</a></li>
				           </c:otherwise>
				    </c:choose>
					<li><a href="#">${page.index}</a></li>
					<c:choose>
				       	<c:when test="${page.index>=page.allpage}">
							<li class="disabled"><a href="#">下一页&rarr;</a></li>
			       		</c:when>              
			            <c:otherwise>
			            	<li><a href="manage_0_10_${page.index+1}.html">下一页&rarr;</a></li>
			            </c:otherwise>
			        </c:choose>
				</c:when>
			</c:choose>
				当前：第${page.index }页,共：${page.allpage }页,每页：${page.pagesize }条数据,共${page.allcount }条数据
			</ul>
		</div>
		<footer class="footer">
		<p>© Company 2015</p>
		</footer>

	</div>
	<!-- /container -->
</body>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</html>