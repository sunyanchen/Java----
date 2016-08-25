<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dologin</title>
</head>
<body>
	<jsp:useBean id="myuser" class="com.yanchen.User"></jsp:useBean>
	<h1>setProperty</h1>
	<hr>
	<!-- 根据表单自动匹配所有属性 -->
	<%-- <jsp:setProperty property="*" name="myuser"/> --%>
	<!-- 根据 表单匹配部分属性值-->
	<%-- 
	<jsp:setProperty property="username" name="myuser"/>
	<jsp:setProperty property="password" name="myuser"/>
	--%>
	<!-- 使用getProperty方式来获取用户名和密码 -->
	用户名：<jsp:getProperty property="username" name="myuser"/>
	密码：<jsp:getProperty property="password" name="myuser"/>
</body>
</html>