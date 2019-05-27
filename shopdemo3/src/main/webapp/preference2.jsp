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
<a href="ShopCard.jsp">我的临时购物车</a>
<form action="Preference2Servlet">
最高学历:<select name="highestEducation">
<option value="小学">小学</option>
<option value="初中">初中</option>
<option value="高中">高中</option>
<option value="大学">大学</option>
<option value="硕士">硕士</option>
<option value="博士">博士</option>
</select><br>
毕业院校：<select name="graduateSchool">
<option value="北京大学">北京大学</option>
<option value="清华大学">清华大学</option>
<option value="郑州大学">郑州大学</option>
<option value="哈弗大学">哈弗大学</option>
</select><br>
所学专业：<input type="text" name="major"><br>
<input type="submit" value="保存">
</form>
</body>
</html>