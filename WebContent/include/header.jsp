<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="header clearfix">
	<nav>
		<ul class="nav nav-pills pull-right">
			<li><a href="index.html">主&nbsp;&nbsp;页</a></li>
			<li><a href="message_3.html">消息查看</a></li>
			<c:choose>
				<c:when test="${sessionScope.userstatus!=null}">
					<li><a href="#">${sessionScope.userstatus.userName}</a></li>
					<c:choose>
						<c:when test="${sessionScope.userstatus.isAdmin==1}">
							<li><a href="#">管理用户</a></li>
						</c:when>
					</c:choose>
				</c:when>
				<c:otherwise>
					<li><a href="login.html">用户登录</a></li>
					<li><a href="register.html">用户注册</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	<h3 class="text-muted">日常事务管理系统</h3>
</div>