package cn.edu.zzti.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.User;

/**
 * Servlet implementation class preference1
 */
@WebServlet("/preference1")
public class preference1 extends HttpServlet {
	
    
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
		    		"<form action=preference1Servlet>\r\n" + 
		    		"学校名称 <input type=\"text\" name=\"schoolname\"><br>\r\n" + 
		    		"专业方向<select name=\"direction\">\r\n" + 
		    		"<option value=\"软件工程互联网方向\">软件工程互联网方向</option>\r\n" + 
		    		"<option value=\"软件工程金融方向\">软件工程金融方向</option>\r\n" + 
		    		"<option value=\"软件工程大数据方向\">软件工程大数据方向</option>\r\n" + 
		    		"<option value=\"软件工程移动方向\">软件工程移动方向</option>\r\n" + 
		    		"</select ><br>\r\n" + 
		    		"<input type=\"submit\" value=\"下一步\">\r\n" + 
		    		"\r\n" + 
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
