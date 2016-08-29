<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
	<h1>登录成功</h1>
	<br>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		//判断用户是否选择记录cookie
		String[] isUserCookie = request.getParameterValues("isUseCookie");
		if(isUserCookie != null && isUserCookie.length > 0)
		{
			String username = URLEncoder.encode(request.getParameter("username"),"utf-8");
			String password = URLEncoder.encode(request.getParameter("password"),"utf-8");
			Cookie usernameCookie = new Cookie("username",username);
			Cookie passwordCookie = new Cookie("password", password);
			usernameCookie.setMaxAge(86400);
			passwordCookie.setMaxAge(86400);
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);
		}
		else
		{
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies)
			{
				if(c.getName().equals("password") || c.getName().equals("username"))
				{
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
	%>
	<a href="user.jsp" target="_blank">查看用户信息</a>
</body>
</html>