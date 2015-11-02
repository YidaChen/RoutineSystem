<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日常事务管理系统-消息列表</title>
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.min.css">
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath %>js/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>js/plugins/code/prettify.css" />
</head>
<body>
		<div class="container">
		<%@ include file="include/header.jsp"%>
		<div class="jumbotron">
			<table class="table table-bordered">
				<tr>
					<td>编号</td>
					<td>标题</td>
					<td>发布时间</td>
					<td>发布人</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${messagelist}" var="message">
					<tr>
					<td>${message.messageId}</td>
					<td><a href="message_2_${message.messageId}.html">${message.messageTitle}</a></td>
					<td>${message.publicTime}</td>
					<td>${message.user.userName}</td>
					<td><a href="message_2_${message.messageId}.html">查看</a></td>
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
			            	<li><a href="message_3_10_${page.index-1}.html">&larr;上一页</a></li>
			            </c:otherwise>
			        </c:choose>
					<li><a href="#">${page.index}</a></li>
					<c:choose>
			        	<c:when test="${page.index==page.allpage}">
							<li class="disabled"><a href="#">下一页&rarr;</a></li>
			        	</c:when>              
			            <c:otherwise>
			            	<li><a href="message_3_10_${page.index+1}.html">下一页&rarr;</a></li>
			            </c:otherwise>
			        </c:choose>
				</c:when>
				<c:otherwise>
				</c:otherwise>
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
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
<script charset="utf-8" src="<%=basePath %>js/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath %>js/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath %>js/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="messagecontent"]', {
			cssPath : '<%=basePath %>js/plugins/code/prettify.css',
			uploadJson : '<%=basePath %>upload',
			fileManagerJson : '<%=basePath %>filemanage',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
</script>
</html>