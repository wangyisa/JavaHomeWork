<%@page import="entitys.User"%>
<%@page import="dao.user.user_login" %>
<%@page import="dao.user.Impl.user_login_Impl" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
<%
	int count = 0;
	Cookie[] cookies = request.getCookies();
	if(cookies!=null)
	{
		String name = null;
		String password =null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("name")) {
				name=cookie.getValue();
			}
			else if(cookie.getName().equals("password")) {
				password=cookie.getValue();
			}
			else if("count".equals(cookie.getName())){
	            count = Integer.parseInt(cookie.getValue());
	            cookie.setValue("" + count);
	        }
		}
		user_login dao = new user_login_Impl();
		User user1 = dao.login(name, password);
		if(user1!=null){
			request.getSession().setAttribute("usersession", user1);
		}
		// 修改 Cookie，更新用户的访问次数
	    Cookie visitTimesCookie = new Cookie("count", Integer.toString(++count));
	    response.addCookie(visitTimesCookie);

	}
%>


	<div class="header">
		<ul>
			<li><a href="index.jsp">首页</a></li>
			<%User user = (User)request.getSession().getAttribute("usersession"); 
				if(user!=null){
			%>
			<li><a href="jsps/user/selfinfo.jsp">个人中心</a></li>
			<li>欢迎你，${usersession.name}</li>
			<li>访问次数<%= count %></li>
			<%}else{%>
			<li><a href="jsps/user/login.jsp">登录</a></li>
			<%}%>
			
		</ul>
		<hr>
	</div>


</body>
</html>