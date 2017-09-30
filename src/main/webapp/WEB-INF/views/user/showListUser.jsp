<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>showListUser</title>
<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
<style type="text/css">
.main{
	margin: 0 auto;
	text-align: center;
}
</style>
</head>

<body>
	<div class="main">
	<table class="table" style="text-align: center;">
	<thead>
		<tr>
			<td class="page-header" style="text-align: center;"><h2>用户列表</h2></td>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td>用户名</td><td>id</td><td>公司名称</td>
		<td>角色</td><td>是否锁定</td><td>密码</td>
		<td>操作</td>
		</tr>
		<c:forEach items="${pageResult.items}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>
					<shiro:hasRole name="admin">${user.uid}</shiro:hasRole>
					<shiro:lacksRole name="admin">您没有权限</shiro:lacksRole>
				</td>
				<td>${user.organizationId}</td>
				<td>
					<select class="form-control">
					<c:forEach items="${user.roles}" var="role">
						<option>${role.description}</option>
					</c:forEach>
				</select>
				</td>
				<td>
					<shiro:hasRole name="admin">${user.locked}</shiro:hasRole>
					<shiro:lacksRole name="admin">您没有权限</shiro:lacksRole>
				</td>
				<td>
					<shiro:hasRole name="admin">${user.password}</shiro:hasRole>
					<shiro:lacksRole name="admin">您没有权限</shiro:lacksRole>
				</td>
				<td>
					<shiro:hasRole name="admin"><a href="removeUser?uid=${user.uid}">删除</a></shiro:hasRole>
					<shiro:lacksRole name="admin">您没有权限</shiro:lacksRole>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
	
	<hr>
	
	<center>
		<div style="float: left;margin-left:100px;">
		<shiro:hasRole name="admin"><a href="save_ForWardUser" class="btn btn-primary btn-lg">新增</a></shiro:hasRole><br>
		<shiro:lacksRole name="admin">您没有权限</shiro:lacksRole><br>
		</div>
		<div style="float: left;margin-left:100px;">
		<a href="main_forward" class="btn btn-primary btn-lg">main</a><br>
		</div>
		<div style="float: none;"></div>
	</center>
	
	<script type="text/javascript">
	function doGoPage(pageNo){
		var url = "${ctx}/showListUser?pageNo="+pageNo;
		window.location.href = url;
	}
	</script>
	<div>
		<ul class="pager">
			<c:if test="${pageResult.pageNo>1}">
			    <li><a href="javascript:doGoPage(${pageResult.pageNo-1})">Previous</a></li>
			</c:if>
			
		    <li><span><label class="label"><font color="blue">共${pageResult.totalPageCount}页</font> </label></span> </li>
		    
		    <c:if test="${pageResult.pageNo<pageResult.totalPageCount}">
			    <li><a href="javascript:doGoPage(${pageResult.pageNo+1})">Next</a></li>
		    </c:if>
		</ul>
	</div>
</body>
</html>
