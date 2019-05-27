package view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginPageViewServlet",urlPatterns = "/LoginPageView")
public class LoginPageViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String error=request.getParameter("error");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>登录页面</TITLE></HEAD>");
        out.println("  <BODY>");
        if(error!=null)
        {
            out.println("请重新登录:<font color='red'>"+error+"</front><br>");
        }
        String body="<form action='/login' method=\"get\">\r\n" +
                "用户名:<input type=\"text\" name=\"username\"><br>\r\n" +
                "密码:<input type=\"text\" name=\"password\"><br>\r\n" +
                "<input type=\"submit\" value=\"登录\"><br>\r\n" +
                "</form>"+"<a href=\"/regist.jsp\"  > <input type=\"submit\" value=\"注册\"></a>\r\n";
        out.println(body);
        out.println("</body>"+
                "</html>");
        out.flush();
        out.close();

    }
}
