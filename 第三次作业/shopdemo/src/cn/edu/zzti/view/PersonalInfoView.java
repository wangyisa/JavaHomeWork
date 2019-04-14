package cn.edu.zzti.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.User;

@WebServlet("/PersonalInfoView")
public class PersonalInfoView extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Object loginTag=request.getSession().getAttribute("user");
	        if(loginTag==null)
	        {
	        	response.sendRedirect("LoginPageView?error="+java.net.URLEncoder.encode("尚未登录","utf-8"));
	        	return ;
	        }
	        User user=(User)loginTag;
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>登录页面</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("欢迎:"+user.getUsername()+"<br>");
		    String body= "<p>首页-->个人中心</p>\r\n" + 
		    		"<form action=\"preference1\">\r\n" + 
		    		"姓名："+user.getUsername()+"<input type=\"submit\" value=\"完善个人信息\">\r\n" + 
		    		"</form>";
			out.println(body);
			out.println("</body>"+
			"</html>");
			out.flush();
			out.close();
		}
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
