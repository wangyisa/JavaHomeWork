package controller;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Preference2Servlet
 */
@WebServlet("/Preference2Servlet")
public class Preference2Servlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("user");
		user.setHighestEducation(request.getParameter("highestEducation"));
		user.setGraduateSchool(request.getParameter("graduateSchool"));
		user.setMajor(request.getParameter("major"));
		UserDao userDao=new UserDaoImpl();
		userDao.updateUser(user);
		request.getRequestDispatcher("/preference.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
