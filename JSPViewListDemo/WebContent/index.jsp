<%@page import="entity.Items"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ItemsDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品列表</title>
<style type="text/css">
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
</head>
<body>
	<h1>商品列表</h1>
	<hr>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>
				<!-- 商品循环开始 -->
				<%
					ItemsDao itemsDao = new	ItemsDao();
					ArrayList<Items> itemlist = itemsDao.getAllItems();
					if(itemlist.size() !=0 && itemlist != null){
						for(int i = 0; i < itemlist.size(); i++){
							Items item = itemlist.get(i);
				%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=item.getId()%>"><img src="images/<%=item.getPicture() %>" width="120" height="90" border="1"/></a>
							</dt>
							<dd class="dd_name"><%=item.getName() %></dd>
							<dd class="dd_city">产地：<%=item.getCity() %>&nbsp;&nbsp;价格：<%=item.getPrice() %>￥</dd>
						</dl>
					</div>
					<!-- 商品循环结束 -->
					<%
						}
					}
					%>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>