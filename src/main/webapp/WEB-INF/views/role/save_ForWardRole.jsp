<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>save_ForWardRole</title>
    <link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>

  </head>
  
  <body>
  <div class="panel panel-default" style="text-align:center;margin-top:10px;">
    <div class="panel-heading">
        <h3 class="panel-title">角色添加</h3>
    </div>
    
        <form:form commandName="role" action="saveRole" method="post" cssClass="form-inline" name="role">
        
	    <div class="panel-body">
	        <div style="margin-bottom:30px;">
			    <input size="28" type="text" class="form-control" name="roleR" id="roleR" placeholder="角色标识 程序中判断使用,如admin">
		    </div>
		    <div style="margin-bottom:30px;">
			    <input size="28" type="text" class="form-control" name="description" id="description" placeholder="角色描述,UI界面显示使用">
		    </div>
		    <div style="margin-bottom:30px;">
			    <c:forEach items="${privileges}" var="privilege">
			     <label class="checkbox-inline">
	        		<input type="checkbox" name="pids"  value="${privilege.pid}">${privilege.description}
	    		 </label>
			    </c:forEach>
		    </div>
		    <div style="margin-bottom:30px;">
			    <label class="radio-inline">
			    	<input name="available" type="radio" value="true">可用
			    </label>
			    <label class="radio-inline">
			    	<input name="available" type="radio" value="false">不可用
			    </label>
		    </div>
	    </div>
    
	    <p class="text-success">
			<a href="main_forward" class="btn btn-primary btn-lg" style="margin-right:50px;">main</a>
			<input type="submit" value="提交" class="btn btn-primary btn-lg">
	    </p>
	    
        </form:form>
    
</div>
  </body>
</html>
