<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%  Object loginTag=request.getSession().getAttribute("user");
     if(loginTag==null)
     {
          response.sendRedirect("LoginPageView?error="+java.net.URLEncoder.encode("尚未登录","utf-8"));
          return ;
     }
    User user=(User)loginTag;
   %>
欢迎:<%=user.getUsername()%><br>
<a href="IndexView">首页</a>
<a href="preference.jsp">个人中心</a>
<a href="preference1.jsp">完善个人信息</a>
<a href="GoodsList.jsp">查看商品列表</a>
<a href="ShopCard.jsp">我的临时购物车</a><br>
<form action="Preference1Servlet">
年龄：<input type="text" name="age"><br>
性别:<input type="checkbox" name="gender" value="男">男
     <input type="checkbox" name="gender" value="女">女<br>
家庭住址：<input type="text" name="address"><br>
联系方式：<input type="text" name="tel"><br>
email：<input type="text" name="email"><br>
<input type="submit" value="下一步">
</form>
</body>
</html>