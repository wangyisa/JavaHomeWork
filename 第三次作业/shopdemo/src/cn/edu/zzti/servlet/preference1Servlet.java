package cn.edu.zzti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.Preference1;
import cn.edu.zzti.entity.User;

/**
 * Servlet implementation class preference1Servlet
 */
@WebServlet("/preference1Servlet")
public class preference1Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String schoolname=request.getParameter("schoolname");
	     String direction=request.getParameter("direction");
	     response.setCharacterEncoding("gbk");
	     PrintWriter out=response.getWriter();
	     out.print(schoolname);
	     User user=(User)request.getSession().getAttribute("user");
	     user.setSchoolname(schoolname);
	     user.setDirection(direction);
	     RequestDispatcher dispatcher=request.getRequestDispatcher("preference2");
	     dispatcher.forward(request, response);
	     
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
