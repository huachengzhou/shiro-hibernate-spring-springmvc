<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>save_ForWardUser</title>
    <link href="${ctx}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap-3.3.7-dist/js/npm.js"></script>
  </head>
  
  <body>
    <div style="text-align:center;">
    <form:form commandName="user" action="saveUser" method="post" cssClass="form-group">
    	<div class="form-group">
		    <label for="name">文本输入</label>
		    <input type="text" name="username" class="form-control" placeholder="username">
  		</div>
    	<div class="form-group">
		    <label for="name">密码输入</label>
		    <input type="text" name="password" class="form-control" placeholder="password">
  		</div>
    	<div class="form-group">
		    <label for="name">公司名称输入</label>
		    <input type="text" name="organizationId" class="form-control" placeholder="organizationId">
  		</div>
  		
    	<br>
    	
    	<div>
		    
		    <c:forEach items="${roles}" var="role">
    		 <label class="checkbox-inline">
    			<input type="checkbox" name="rid" id="inlineCheckbox${role.rid}" value="${role.rid}">${role.description}
		    </label>
    		</c:forEach>
		    
		    <label class="radio-inline">
		    	<input type="radio" name="locked" value="true" id="optionsRadios3" checked>锁定
		    </label>
		    <label class="radio-inline">
		    	<input type="radio" name="locked" value="false" id="optionsRadios4" checked>启用
		    </label>
		</div>
    	
    	<div class="panel panel-default">
		    <div class="panel-body">
	    		<input type="reset" value="重置" class="btn-primary btn-lg"><br>
		    </div>
		    
		    <div class="panel-body">
	    		<input type="submit" value="submit" class="btn-primary btn-lg"><br>
		    </div>
		</div>
    </form:form>
    </div>
  </body>
</html>
