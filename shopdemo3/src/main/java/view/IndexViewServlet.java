package view;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "IndexViewServlet",urlPatterns = "/IndexView")
public class IndexViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = 0;
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password =null;
        if(cookies!=null)
        {

            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) {
                    username=cookie.getValue();
                }
                else if(cookie.getName().equals("password")) {
                    password=cookie.getValue();
                }
                else if("count".equals(cookie.getName())){
                    count = Integer.parseInt(cookie.getValue());
                    cookie.setValue("" + count);
                }
            }
            // 修改 Cookie，更新用户的访问次数
            Cookie visitTimesCookie = new Cookie("count", Integer.toString(++count));
            response.addCookie(visitTimesCookie);
        }
        Object loginTag=request.getSession().getAttribute("user");
        if(loginTag==null&&username!=null&&password!=null)
        {
            response.sendRedirect("LoginPageView?error="+ URLEncoder.encode("尚未登录","utf-8"));
        }
        User user=(User)loginTag;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>登录页面</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("欢迎:"+user.getUsername()+"<br>");
        out.println("访问次数："+count);
        String body= "<a href=\"IndexView\">首页</a><br>\r\n" +
                "<a href=\"/preference.jsp\">个人中心</a><br>\r\n"+
                "<a href=\"/preference1.jsp\">完善个人信息</a><br>\r\n"+
                "<a href=\"/GoodsList.jsp\">查看商品列表</a><br>\r\n"+
                "<a href=\"/ShopCard.jsp\">我的临时购物车</a>\r\n";
        out.println(body);
        out.println("</body>"+
                "</html>");
        out.flush();
        out.close();
    }

}
