<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yanchen.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
	<%
		User user = new User(); 
		user.setUsername("admin");
		user.setPassword("123456");
	%>
	<h1>普通的方式创建javabean实例</h1>
	<hr>
		用户名：<%=user.getUsername() %>
		密码：<%=user.getPassword() %>
</body>
</html>