<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
	<h1>用户登录</h1>
	<hr>
	<%
		request.setCharacterEncoding("utf-8");
		String username = "";
		String password = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0)
		{
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
		}
	%>
	<form action="dologin.jsp" name="loginForm" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name="username" type="text" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" type="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked">是否使用cookies</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录"/> <input type="reset" value="取消"></td>
			</tr>
		</table>
	</form>
</body>
</html>