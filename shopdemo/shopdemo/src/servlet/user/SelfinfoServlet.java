package servlet.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.user.user_selfinfo;
import dao.user.Impl.user_selfinfo_Impl;
import entitys.User;
@WebServlet("/SelfinfoServlet")
public class SelfinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//专业方向（要存储到数据库，而从网页获取的都是英文简写，所以创建map进行解释）
		Map<String, String> professionMap = new HashMap<String, String>();
		professionMap.put("ruanjian", "软件工程");
		professionMap.put("tumu", "土木工程");
		professionMap.put("gongshang", "工商管理");
		professionMap.put("dianqi", "电气自动化");
		professionMap.put("jinrong", "金融工程");
		//得到技术的数组
		String[] skills = request.getParameterValues("skill");
		String profession = professionMap.get(request.getParameter("profession"));
		String school = request.getParameter("school");
		//将存储技术的数组转化成字符串
		String stringskills = String.join(",", skills);
		User user = (User)session.getAttribute("usersession");
		int id = user.getId();
		//更新数据库
		user_selfinfo dao = new user_selfinfo_Impl(); 
		dao.selfinfoinsert(id, school, profession, stringskills);
		//更新session中user的信息，
		user.setSchool(school);
		user.setProfession(profession);
		user.setSkill(stringskills);
		request.getSession().setAttribute("usersession", user);
		response.sendRedirect("jsps/user/selfinfo.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
