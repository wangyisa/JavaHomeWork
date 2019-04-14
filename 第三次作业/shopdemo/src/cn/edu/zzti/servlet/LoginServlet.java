package cn.edu.zzti.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.edu.zzti.entity.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public String checkLogin(User user)
	{
		Map<String, String> map=new HashMap<>();
		map.put("demo1", "12345");
		map.put("demo2", "1234");
		map.put("demo3", "123");
	    String password=map.get(user.getUsername())	;
		String error="输入密码或账号错误";
		if(user.getUsername()==null||"".equals(user.getUsername().trim())
			||user.getPassword()==null||"".equals(user.getPassword().trim()))
		{
			error="用户名或密码不能为空";
		}
		else if(user.getPassword().equals(password))
		{
			error=null;
		}
		
		return error;
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user = new User(username,password);
		String error=checkLogin(user);
		String path="IndexView";
		if(error==null)
		{
			request.getSession().setAttribute("user", user);
		}
		else
		{
			path="LoginSuccess";
			request.setAttribute("error", error);
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
