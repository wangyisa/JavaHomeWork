<%@page import="entitys.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<style type="text/css">
	a {
		text-decoration: none
	}
	.header,li{
		list-style: none;
		margin-right: 50px;
		font-size: 30px;
		float: left;
	}
</style>
</head>
<body>
	<div class="header">
		<ul>
			<li><a href="/shopdemo/index.jsp">首页</a></li>
			<li><a href="selfinfo.jsp">个人中心</a></li>
			<li>欢迎你，${usersession.name}</li>
		</ul>
		<hr>
	</div>
	<br><br><br><br>
	<ul>
		<li style="float: none;">姓名：${usersession.name}</li>
		<%
			User user = (User)session.getAttribute("usersession");
		%>
		<%if(user.getSchool()!=null){ %>
		<li style="float: none;">学校：${usersession.school }</li>
		<%} %>
		<%if(user.getProfession()!=null){ %>
		<li style="float: none;">专业方向：${usersession.profession }</li>
		<%} %>
		<%if(user.getSkill()!=null){ %>
		<li style="float: none;">掌握技术：${usersession.skill }</li>
		<%} %>
		<a href="preference1.jsp" >完善个人信息</a>
	</ul>
	
	
	
</body>
</html>