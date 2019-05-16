<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完善信息1</title>
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
	<form action="preference2.jsp" method="get">
		<ul>
			<li>
			学校名称：<input type="text" name="school">
			</li>
			<li>
			专业名称：<select name="profession">
					<option value="ruanjian">软件工程</option>
					<option value="tumu">土木工程</option>
					<option value="gongshang">工商管理</option>
					<option value="dianqi">电气自动化</option>
					<option value="jinrong">金融工程</option>
				</select>
			</li>
		</ul>
		<input type="submit" value="下一步">
	</form>	
</body>
</html>