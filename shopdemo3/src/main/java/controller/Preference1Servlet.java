package controller;

import cn.hutool.db.Session;
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
 * Servlet implementation class Preference1Servlet
 */
@WebServlet("/Preference1Servlet")
public class Preference1Servlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		User user=(User)request.getSession().getAttribute("user");
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setGender(request.getParameterValues("gender")[0]);
		user.setAddress(request.getParameter("address"));
		user.setTel(request.getParameter("tel"));
		user.setEmail(request.getParameter("email"));
		UserDao userDao=new UserDaoImpl();
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher("/preference2.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
