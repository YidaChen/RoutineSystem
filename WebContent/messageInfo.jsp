<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日常事务管理系统-消息详情</title>
<link rel="stylesheet" type="text/css" media="screen" href="bootstrap/css/bootstrap.min.css">
<link href="css/jumbotron-narrow.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath %>js/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>js/plugins/code/prettify.css" />
</head>
<body>
	<div class="container">
	<%@ include file="include/header.jsp"%>
	<div class="messagecontent">
		<h2>${message.messageTitle }</h2>
		${message.messageContent }
		发布人：${message.user.userName }、
		发布日期：${message.publicTime }
	</div>
	<div class="jumbotron">
		<table class="table table-bordered">
			<tr>
				<td>回复内容</td>
				<td>回复时间</td>
				<td>回复人</td>
			</tr>
			<c:forEach items="${replyList}" var="reply">
				<tr>
					<td>${reply.replyContext}</td>
					<td>${reply.replyDate}</td>
					<td>${reply.user.userName}</td>
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
				           	<li><a href="message_2_${message.messageId }_10_${page.index-1}.html">&larr;上一页</a></li>
				           </c:otherwise>
				    </c:choose>
					<li><a href="#">${page.index}</a></li>
					<c:choose>
				       	<c:when test="${page.index>=page.allpage}">
							<li class="disabled"><a href="#">下一页&rarr;</a></li>
			       		</c:when>              
			            <c:otherwise>
			            	<li><a href="message_2_${message.messageId }_10_${page.index+1}.html">下一页&rarr;</a></li>
			            </c:otherwise>
			        </c:choose>
				</c:when>
			</c:choose>
				当前：第${page.index }页,共：${page.allpage }页,每页：${page.pagesize }条数据,共${page.allcount }条数据
			</ul>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-10">
				<br/>
		    	<button type="button" class="btn btn-success"  id="btn_reply">我要回复</button>
			</div>
		</div>
		<div class="reply">
			<form class="form-horizontal" action="reply_1_${message.messageId }.html" method="post">
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<h2>消息回复</h2>
					</div>
			  	</div>
				<div class="form-group">
					 <div class="col-sm-10">
						<textarea name="replycontent" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
				    </div>
			  	</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
			      		<button type="submit" class="btn btn-success"  name="button">全盘就绪：发射</button>
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
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
<script charset="utf-8" src="<%=basePath %>js/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath %>js/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=basePath %>js/plugins/code/prettify.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="replycontent"]', {
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
<script type="text/javascript">
	$(function(){
		$("#btn_reply").click(function(){
			$(".reply").fadeOut(200);
			$(".reply").css("display","block");
		});
		
	});
</script>
</html>
