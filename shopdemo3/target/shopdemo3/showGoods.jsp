<%@ page import="dao.GoodsDao" %>
<%@ page import="model.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.impl.GoodsDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>student</h2>

    <table border="1" style="width:400px;">
        <form>
            <tr>
                <td>id</td> <td>title </td>  <td>descrption</td> <td>type</td> <td>price</td> <td>number</td> <td>attributes</td> <td>加购物车</td>
            </tr>
            <%
                GoodsDao goodsDao=new GoodsDaoImpl();
                List<Goods> list= goodsDao.findAll();
                for(Goods goods:list){
                    %>
            <tr>
                <td><%= goods.getId()%></td>
                <td><%=goods.getTitle() %></td>
                <td><%= goods.getDescription()%></td>
                <td><%=goods.getType() %></td>
                <td><%= goods.getPrice()%></td>
                <td><%=goods.getNumber() %></td>
                <td><%=null%></td>
                <td><input type="submit" value="加购物车"></td>
            </tr>
        </form>
        <%
            }
        %>
    </table>
</head>
<body>

</body>
</html>
