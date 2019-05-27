package controller;

import cn.hutool.extra.servlet.ServletUtil;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public String checkLogin(User user) {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.FindPasswordByUsername(user.getUsername()));
        String error = "输入密码或账号错误";
        if (user.getUsername() == null || "".equals(user.getUsername().trim())
                || user.getPassword() == null || "".equals(user.getPassword().trim())) {
            error = "用户名或密码不能为空";
        } else if (user.getPassword().equals(userDao.FindPasswordByUsername(user.getUsername()))) {
            error = "";
        }

        return error;

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Cookie cookie = ServletUtil.getCookie(request, "username");
       // if(cookie!=null){
         //   System.out.println("cookie is not null");
          //  request.getRequestDispatcher("/IndexView.jsp").forward(request,response);
           // response.sendRedirect(request.getContextPath()+"/IndexView");
        //}
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String error = null;
        error = checkLogin(user);
        String path = "/IndexView";
        if (error.equals("")) {
            Cookie namecookie = new Cookie("username", username);
            Cookie passwordcookie = new Cookie("password", password);
            namecookie.setMaxAge(24*3600);
            //namecookie.setPath("/");
            passwordcookie.setMaxAge(24*3600);
            //passwordcookie.setPath("/");
            response.addCookie(namecookie);
            response.addCookie(passwordcookie);
            Cookie visittimesCookie = new Cookie("count", "0");
            response.addCookie(visittimesCookie);
            request.getSession().setAttribute("user", user);
        } else {
            path = "/LoginPageView";
            request.setAttribute("error", error);
        }
        request.getRequestDispatcher(path).forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
