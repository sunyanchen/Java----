<%@page import="java.util.ArrayList"%>
<%@page import="java.net.*" %>
<%@page import="entity.Items"%>
<%@page import="dao.ItemsDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="js/lhgcore.js"></script>
    <script type="text/javascript" src="js/lhgdialog.js"></script>
    <script type="text/javascript">
    function selflog_show(id)
    { 
       var num =  document.getElementById("number").value; 
       J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '<%=path%>/servlet/CartServlet?id='+id+'&num='+num+'&action=add', cover:true});
    }
    function add()
    {
       var num = parseInt(document.getElementById("number").value);
       if(num<100)
       {
          document.getElementById("number").value = ++num;
       }
    }
    function sub()
    {
       var num = parseInt(document.getElementById("number").value);
       if(num>1)
       {
          document.getElementById("number").value = --num;
       }
    }

   </script>
<title>商品详情</title>
 <style type="text/css">
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
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
	<h1>商品详情</h1>
	<hr>
	<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
			<tr>
			<%
				ItemsDao itemsDao = new ItemsDao();
				Items item = itemsDao.getItemById(Integer.parseInt(request.getParameter("id")));
				if(item != null){
					
			%>
			<!-- 商品详情 -->
				<td width="70%" valign="top">
					<table>
						<tr>
							<td rowspan="4"><img src="images/<%=item.getPicture() %>"  width="200" height="160"/></td>
						</tr>
						<tr>
							<td><B><%=item.getName() %></B></td>
						</tr>
						<tr>
							<td>产地：<%=item.getCity() %></td>
						</tr>
						<tr>
							<td>价格：<%=item.getPrice() %>￥</td>
						</tr>
						<tr>
                 			<td>购买数量：<span id="sub" onclick="sub();">-</span><input type="text" id="number" name="number" value="1" size="2"/><span id="add" onclick="add();">+</span></td>
              			 </tr> 
					</table>
					<div id="cart">
              		     <img src="images/buy_now.png"><a href="javascript:selflog_show(<%=item.getId()%>)"><img src="images/in_cart.png"></a><a href="servlet/CartServlet?action=show"><img src="images/view_cart.jpg"/></a>
             		</div>
					
				</td>
				<%
				}
				%>
				<!-- 浏览过的商品 -->
				<%
					String list = "";
					//从客户端获取cookie的集合
					Cookie[] cookies = request.getCookies();
					if(cookies != null && cookies.length>0){
						for(Cookie c : cookies){
							if(c.getName().equals("ListViewCookie")){
								list = c.getValue();
							}
						}
					}
					
					list += request.getParameter("id") + ",";
					System.out.println(list);
					System.out.println("list.length: = " + list.length());
					String[] arr = list.split(",");
					//如果存储的cookie大于1000
					if(arr != null && arr.length>0){
						if(arr.length >= 1000){
							list = "";
						}
					}
					Cookie cookie = new Cookie("ListViewCookie",list);
					response.addCookie(cookie);
				%>
				<td width="30%" bgcolor="" align="center">
					<br>
					<b>您浏览过的商品</b><br>
					<!-- 循环开始 -->
					<%
						ArrayList<Items> itemList = itemsDao.getViewList(list);
						if(itemList != null && itemList.size()>0){
							System.out.println("itemList.size:" + itemList.size());
							for(Items itemTmp : itemList){
								

					%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=itemTmp.getId()%>"><img src="images/<%=itemTmp.getPicture() %>" width="120" height="90" border="1"/></a>
							</dt>
							<dd class="dd_name"><%=itemTmp.getName() %></dd>
							<dd class="dd_city">产地：<%=itemTmp.getCity() %>  &nbsp;&nbsp;价格：<%=itemTmp.getPrice() %>￥</dd>
						</dl>
					</div>
					<%
							}
						}
					%>
					<!-- 循环结束 -->
				</td>
			</tr>
		</table>
	</center>
</body>
</html>