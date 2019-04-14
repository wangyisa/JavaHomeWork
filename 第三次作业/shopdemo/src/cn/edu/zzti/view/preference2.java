package cn.edu.zzti.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.User;


@WebServlet("/preference2")
public class preference2 extends HttpServlet {
	
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
		out.println("  <HEAD><TITLE>个人填些</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("欢迎:"+user.getUsername()+"<br>");
	    String body=
	    		"<form action=\"preference2Servlet\">\r\n" + 
	    		"掌握技术 <input type=\"checkbox\" name=\"talent\" value=\"android\">android\r\n" + 
	    		"<input type=\"checkbox\" name=\"talent\" value=\"IOS\">IOS\r\n" + 
	    		"<input type=\"checkbox\" name=\"talent\" value=\"javaweb\">javaweb\r\n" + 
	    		"<input type=\"checkbox\" name=\"talent\" value=\"c#\">c#<br>\r\n" + 
	    		"<input type=\"submit\" value=\"完成\">     \r\n" + 
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
