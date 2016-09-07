<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="css/style1.css" />
<title>购物车</title>
</head>
<body>
	<h1>我的购物车</h1>
	<a href="index.jsp">首页</a> >> <a href="index.jsp">商品列表</a>
	<hr>
	<div id="shopping">
		<form action="" method="">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<tr name="products" id="product_id_1">
					<td class="thumb"><img src="images/001.jpg" /><a href="">沃特篮球鞋</a></td>
					<td class="number">180</td>
					<td class="price" id="price_id_1">
						<span>180</span>
						<input type="hidden" value="" />
					</td>
					<td class="number">
                     	1
					</td>                        
                    <td class="delete">
					  <a href="" onclick="">删除</a>					                  
					</td>
				</tr>
			</table>
			<div class="total"><span id="total">总计：180￥</span></div>
			<div class="button"><input type="submit" value=""/></div>
		</form>
	</div>
</body>
</html>