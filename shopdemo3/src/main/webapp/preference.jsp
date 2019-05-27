<%@ page import="dao.UserDao" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: wx
  Date: 2019/5/26
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<%  Object loginTag=request.getSession().getAttribute("user");
    if(loginTag==null)
    {
        response.sendRedirect("LoginPageView?error="+java.net.URLEncoder.encode("尚未登录","utf-8"));
        return ;
    }
    UserDao userDao=new UserDaoImpl();
    User user=(User)loginTag;
%>
欢迎:<%=user.getUsername()%><br>
<a href="IndexView">首页</a>
<a href="preference.jsp">个人中心</a>
<a href="preference1.jsp">完善个人信息</a>
<a href="GoodsList.jsp">查看商品列表</a>
<a href="ShopCard.jsp">我的临时购物车</a><br>

年龄：<%=userDao.selectUserByUsername(user.getUsername()).getAge()%><br>
性别：<%=userDao.selectUserByUsername(user.getUsername()).getGender()%><br>
家庭住址：<%=userDao.selectUserByUsername(user.getUsername()).getAddress()%><br>
联系方式：<%=userDao.selectUserByUsername(user.getUsername()).getTel()%><br>
email:<%=userDao.selectUserByUsername(user.getUsername()).getTel()%><br>
最高学历:<%=userDao.selectUserByUsername(user.getUsername()).getHighestEducation()%><br>
毕业院校:<%=userDao.selectUserByUsername(user.getUsername()).getGraduateSchool()%><br>
所学专业:<%=userDao.selectUserByUsername(user.getUsername()).getMajor()%>
</body>
</html>
