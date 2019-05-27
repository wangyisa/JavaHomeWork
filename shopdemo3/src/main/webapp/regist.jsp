<%--
  Created by IntelliJ IDEA.
  User: wx
  Date: 2019/5/26
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="IndexView">首页</a>
<a href="preference.jsp">个人中心</a>
<a href="preference1.jsp">完善个人信息</a>
<a href="GoodsList.jsp">查看商品列表</a>
<a href="ShopCard.jsp">我的临时购物车</a>
<form action="/IndexServlet" method="post">
    用户名:<input type="text" name="username"><br>
    密码:<input type="text" name="password"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
