<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
</head>
<body>
	<div style="margin-top:40px;">
		<center>
			<p class="text-success glyphicon glyphicon-heart"><shiro:user>欢迎您!${user.username}</shiro:user></p><!-- user标签  认证通过或已记住的用户。 -->
			
			<p class="text-info glyphicon glyphicon-user">
			<shiro:hasRole name="admin"><!-- 判断是否包含某个角色 -->
				欢迎有admin角色的用户！<shiro:principal /><br>
			</shiro:hasRole>            <!-- principal 标签  输出当前用户信息，通常为登录帐号信息。 -->
			</p>
			<p class="text-info glyphicon glyphicon-user">
			<shiro:hasRole name="admin">
				<a href="save_ForWardRole" class="btn btn-primary btn-lg">增加角色</a>
				<a href="showRoleList" class="btn btn-primary btn-lg">查看角色</a>
			</shiro:hasRole>    
			</p>
			
				<hr>
				
			<p class="text-center glyphicon glyphicon-euro">
			<shiro:hasPermission name="user:save">
			欢迎有user:save权限的用户！<shiro:principal />
				<hr>
			</shiro:hasPermission>
			</p>

			<p class="text-muted glyphicon glyphicon-heart">
			<shiro:authenticated>认证用户</shiro:authenticated><!-- authenticated标签  已认证通过的用户。不包含已记住的用户，这是与user标签的区别所在。 -->
			</p>
			
		</center>
	</div>
	
	
	<ul class="list-group">
	    <li class="list-group-item"><a href="showInfoList" class="list-group-item btn btn-primary btn-lg">信息列表</a></li>
	    <li class="list-group-item"><a href="showListUser" class="list-group-item btn btn-primary btn-lg">用户列表</a></li>
	    <li class="list-group-item"><a href="logout" class="list-group-item btn btn-primary btn-lg">退出</a></li>
	</ul>
	
</body>
</html>