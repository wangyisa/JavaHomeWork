<%@ page import="model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: wx
  Date: 2019/4/29
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Object loginTag=request.getSession().getAttribute("user");
    String name;
    if(loginTag==null)
    {
       name="尚未登陆";
    }
    else {
        User user = (User) loginTag;
        name="欢迎："+user.getUsername();

    }
    request.setCharacterEncoding("utf-8");
    Object goodsObject =request.getSession().getAttribute("myGoodsList");
    List<Goods> myGoodgList = null;
    if(goodsObject==null)
    {
        myGoodgList=new ArrayList<Goods>();
        request.getSession().setAttribute("myGoodsList",myGoodgList);
    }
    else{
        myGoodgList=(ArrayList<Goods>)goodsObject;
    }
%>
<%=name%><br>
<html>
<head>
    <title>临时购物车</title>
</head>
<body>
<a href="IndexView">首页</a>
<a href="preference.jsp">个人中心</a>
<a href="preference1.jsp">完善个人信息</a>
<a href="GoodsList.jsp">查看商品列表</a>
<a href="ShopCard.jsp">我的临时购物车</a>
<table border="1">
<tr>
    <td>商品id</td>
    <td>商品名字</td>
    <td>价格</td>
    <td>数量</td>
    <td>总价</td>
    <td>操作</td>
</tr>
<%
    for(Goods goods:myGoodgList)
    {
        %>
<tr>
    <form action="ShopCardController?type=removeCard"method="post">
<td><%= goods.getId()%></td>
<td><%=goods.getTitle() %></td>
<td><%= goods.getPrice()%></td>
<td><%=goods.getNumber() %></td>
<td><%=goods.getPrice()*goods.getNumber()%></td>
        <input name="goodId" value='<%= goods.getId()%>' type="hidden">
        <td><input type="submit" value="删除"></td>
    </form>
<%
    }
%>

</body>
</html>
