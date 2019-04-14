package cn.edu.zzti.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.zzti.entity.Preference1;
import cn.edu.zzti.entity.Preference2;
import cn.edu.zzti.entity.User;

@WebServlet("/preference2Servlet")
public class preference2Servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String []talents=request.getParameterValues("talent");
		 User user=(User)request.getSession().getAttribute("user");
	     response.setCharacterEncoding("gbk");
	     PrintWriter out=response.getWriter();
	     out.print(user.getSchoolname());
	 
	     for(String s:talents)
	     {
	    	 user.getTalents().add(s);
	     }
	     RequestDispatcher dispatcher=request.getRequestDispatcher("Addpreference");
	     dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
