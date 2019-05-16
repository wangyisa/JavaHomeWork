<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完善信息2</title>
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
	<form action="/shopdemo/SelfinfoServlet" method="get">
		<ul>
			<li>掌握技术</li>
			<input type="checkbox" name = "skill" value="android" >android
			<input type="checkbox" name = "skill" value="IOS">IOS
			<input type="checkbox" name = "skill" value="java web">java web
			<input type="checkbox" name = "skill" value="c#">c#
		</ul>
		<input type = "hidden" name = "school" value=<%=request.getParameter("school") %>>
		<input type = "hidden" name = "profession" value=<%=request.getParameter("profession") %>>
		<input type="submit" value="完成">
	</form>
</body>
</html>