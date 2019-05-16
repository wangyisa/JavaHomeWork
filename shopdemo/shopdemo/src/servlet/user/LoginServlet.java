package servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.user.user_login;
import dao.user.Impl.user_login_Impl;
import entitys.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String auto = request.getParameter("auto");
		System.out.println(auto);
		user_login dao = new user_login_Impl();
		User user = dao.login(name, password);

		if(user == null) {
			request.getRequestDispatcher("jsps/user/login.jsp?msg=0").forward(request, response);
			//response.sendRedirect("jsps/user/login.jsp?msg=0");
		}else {
			if(auto!=null&&auto.equals("on")) {
				Cookie namecookie = new Cookie("name", name);
				Cookie passwordcookie = new Cookie("password",password);
				namecookie.setMaxAge(24*3600);
				//namecookie.setPath("/");
				passwordcookie.setMaxAge(24*3600);
				//passwordcookie.setPath("/");
				response.addCookie(namecookie);
				response.addCookie(passwordcookie);
			}
			Cookie visittimesCookie = new Cookie("count", "0");
	        response.addCookie(visittimesCookie);

			//将用户信息保存在session
			request.getSession().setAttribute("usersession", user);
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
