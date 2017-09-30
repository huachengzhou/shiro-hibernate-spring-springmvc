<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>不支持的媒体类型</title>
</head>

<body>
	<center>
		<label>code 415</label> <label><font color="red">${ex}</font></label>
	</center>
	<hr>
	<center>
		<a href="main_forward">main</a>
	</center>
</body>
</html>
