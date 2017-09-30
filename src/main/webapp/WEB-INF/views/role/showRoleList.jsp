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
    <title>showRoleList</title>
	<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
  </head>
  
  <body>
    <center>
		<table class="table table-bordered" style="text-align:center;">
			<div class="page-header">
			    <h1>
			        <small><shiro:user>Role</shiro:user></small>
			    </h1>
			</div>
			<tbody>
				<tr>
					<td>description</td>
					<td>role</td>
					<td>privileges</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${pageResult.items}" var="role">
					<tr>
						<td>${role.description}</td>
						<td>${role.role}</td>
						<td>
							<c:forEach items="${role.privileges}" var="privilege">
							<span><font>${privilege.description}</font></span>
							</c:forEach>
						</td>
						<td>
							<shiro:hasPermission name="user:remove">
								<label><a href="removeRole?rid=${role.rid}">刪除</a></label>
							</shiro:hasPermission>
							<shiro:lacksPermission name="user:remove">
								<label style="color:red;">您没有删除权限,请找管理员申请</label>
							</shiro:lacksPermission>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
	
	<hr>
	
	<div title="xx" style="text-align: center;">
			<a href="main_forward"  class="btn btn-primary btn-lg" style="margin-right:100px;">main</a>
			<a href="save_ForWardRole" class="btn btn-primary btn-lg" style="margin-right:100px;">增加角色</a>
	</div>
	
	
	<script type="text/javascript">
	function doGoPage(pageNo){
		var url = "${ctx}/showRoleList?pageNo="+pageNo;
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
