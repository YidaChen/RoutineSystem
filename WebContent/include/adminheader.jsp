<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<li><a href="#">${sessionScope.userstatus.userName}</a></li>
						</c:when>
					</c:choose>
				</c:when>
				<c:otherwise>
					<!-- 无权限操作未登录 -->
					<script type="text/javascript">
						window.location.href = "index.html";
					</script>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
	<h3 class="text-muted">日常事务管理系统管理界面</h3>
</div>