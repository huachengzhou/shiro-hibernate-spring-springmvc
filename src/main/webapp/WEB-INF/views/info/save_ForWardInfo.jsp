<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Info</title>
</head>

<body>
	<center>
		<div style="margin-top:50px;">
		<form:form commandName="info" action="saveInfo" method="post">
			<label>信息</label><br>
			<textarea rows="9" cols="30" name="description"></textarea><br>
			<input type="submit" value="submit"><br>
		</form:form>
		</div>
	</center>
	<hr>
	<center>
		<a href="main_forward">main</a>
	</center>
</body>
</html>
