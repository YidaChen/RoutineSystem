<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.min.css">
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath %>js/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>js/plugins/code/prettify.css" />
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
</head>
<body>
		<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li class="active"><a href="#">主&nbsp;&nbsp;页</a></li>
					<li><a href="#">消息查看</a></li>
					<li><a href="#">消息回复</a></li>
					<li><a href="#">用户注册</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">日常事务管理系统用户登录</h3>
		</div>

		<div class="jumbotron">
			<%=htmlData%>
			<table class="table table-bordered">
				<tr>
					<td>编号</td>
					<td>标题</td>
					<td>发布时间</td>
					<td>发布人</td>
					<td>回复</td>
					<td>操作</td>
				</tr>
				<tr>
					<td>1</td>
					<td>测试消息</td>
					<td>2015年10月28日03:35:51</td>
					<td>admin</td>
					<td>10</td>
					<td><a href="#">查看</a></td>
				</tr>
				<tr>
					<td>2</td>
					<td>测试消息</td>
					<td>2015年10月28日03:35:51</td>
					<td>admin</td>
					<td>10</td>
					<td><a href="#">查看</a></td>
				</tr>
				<tr>
					<td>4</td>
					<td>测试消息</td>
					<td>2015年10月28日03:35:51</td>
					<td>admin</td>
					<td>10</td>
					<td><a href="#">查看</a></td>
				</tr>
			</table>
		</div>
		<form class="form-horizontal" action="message?option=1" method="post">
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<h2>我也发一手</h2>
				</div>
		  	</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-1 control-label">标题</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="messagetitle" placeholder="标题">
			    </div>
		  	</div>
		  	<div class="form-group">
				<label for="inputEmail3" class="col-sm-1 control-label">内容</label>
		  	</div>
			<div class="form-group">
				 <div class="col-sm-10">
					<textarea name="messagecontent" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
			    </div>
		  	</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
		      		<button type="submit" class="btn btn-success"  name="button">全盘就绪：发射</button>
				</div>
			</div>
		</form>
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
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>