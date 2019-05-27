<%@ page import="dao.GoodsDao" %>
<%@ page import="model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.impl.GoodsDaoImpl" %>
<%@ page import="model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: wx
  Date: 2019/4/29
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    GoodsDao goodsDao=new GoodsDaoImpl();
    List<Goods> list= goodsDao.findAll();
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
%>
<%=name%><br>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<a href="IndexView">首页</a>
<a href="preference.jsp">个人中心</a>
<a href="preference1.jsp">完善个人信息</a>
<a href="GoodsList.jsp">查看商品列表</a>
<a href="ShopCard.jsp">我的临时购物车</a>
    <a href="ShopCardController?type=cardList">查看购物车</a>
     <table border="1">
         <tr>
             <td>商品id</td>
             <td>商品名字</td>
             <td>商品描述</td>
             <td>类型</td>
             <td>价格</td>
             <td>数量</td>
             <td>属性</td>
             <td>操作</td>
         </tr>
         <%
             for (Goods goods:list)
             {
                 %>
         <tr>
             <form action="ShopCardController?type=addCard" method="post">
                 <td><%= goods.getId()%></td>
                 <td><%=goods.getTitle() %></td>
                 <td><%= goods.getDescription()%></td>
                 <td><%=goods.getType() %></td>
                 <td><%= goods.getPrice()%></td>
                 <td><%=goods.getNumber() %></td>
                 <td><%=""%></td>
                 <input name="goodId" value='<%= goods.getId()%>' type="hidden">
                 <input name="title" value='<%=goods.getTitle()%>' type="hidden">
                 <input name="price" value='<%=goods.getPrice()%>' type="hidden">
                 <td><input type="submit" value="加入购物车"></td>
             </form>
         </tr>
                 <%
             }
         %>
     </table>

</body>
</html>
