<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
</head>
<body>
	<div class="panel panel-default" style="margin:0 auto;text-align:center;">
	<form:form commandName="user" action="login" method="post">
	
	    <div class="panel-body">
	    	<div class="page-header">
		    <h1>shiro + hibernate + spring + springmvc
		        <small><label class="label label-info">Data</label></small>
		    </h1>
		</div>
			<label>${errorMsg}</label><br> 
			<input type="text" class="form-control" name="username" placeholder="账号" size="22" value='<shiro:principal />'> <br>
			<input type="password" name="password" class="form-control" placeholder="密码" size="22">
			<label>${error}</label>
	    </div>
	    
    	<div class="panel-footer">
			<input class="btn btn-primary btn-lg" type="submit" value="submit"><br>
    	</div>
    	
	</form:form>
</div>
</body>
</html>