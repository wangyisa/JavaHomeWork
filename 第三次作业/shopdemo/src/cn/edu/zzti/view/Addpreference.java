package cn.edu.zzti.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.Preference1;
import cn.edu.zzti.entity.Preference2;
import cn.edu.zzti.entity.User;


@WebServlet("/Addpreference")
public class Addpreference extends HttpServlet {
	
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
		out.println("学校名字:"+user.getSchoolname()+"<br>");
		out.println("专业方向:"+user.getDirection()+"<br>");
		for(String s:user.getTalents())
		{
		out.println("掌握技术:"+s+"<br>");
		}
		out.println("</body>"+
		"</html>");
		out.flush();
		out.close();
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
