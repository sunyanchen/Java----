<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>useBean</title>
</head>
<body>
	<jsp:useBean id="myuser" class="com.yanchen.User" ></jsp:useBean>
	<h1>使用userBean创建javaBean实例</h1>
	<hr>
		用户名：<%=myuser.getUsername() %>
		密码：<%=myuser.getPassword() %>
</body>
</html>