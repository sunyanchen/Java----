<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
</head>
<body>
	<h1>用户信息</h1>
	<hr>
	<%
		request.setCharacterEncoding("utf-8");
		String username = "";
		String password = "";
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies)
		{
			if(c.getName().equals("username"))
			{
				username = URLDecoder.decode(c.getValue(),"utf-8");
			}
			if(c.getName().equals("password"))
			{
				password = URLDecoder.decode(c.getValue(),"utf-8");
			}
		}
	%>
	用户名：<%=username %><br>
	密码：<%=password %><br>
</body>
</html>