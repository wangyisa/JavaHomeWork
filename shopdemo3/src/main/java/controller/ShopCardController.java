package controller;

import model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ShopCardController", urlPatterns = "/ShopCardController")
public class ShopCardController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("goodId"));
        Object goodsObject = request.getSession().getAttribute("myGoodsList");
        List<Goods> myGoodsList;
        if (goodsObject == null) {
            myGoodsList = new ArrayList<>();
            request.getSession().setAttribute("myGoodsList", myGoodsList);
        } else {
            myGoodsList = (ArrayList<Goods>) goodsObject;
        }
        String type = request.getParameter("type");
        if ("addCard".equals(type)) {
            int id = Integer.parseInt(request.getParameter("goodId"));
            int number = 1;
            Goods goods = new Goods();
            goods.setId(id);
            goods.setTitle(request.getParameter("title"));
            goods.setPrice(Float.parseFloat(request.getParameter("price")));
            goods.setNumber(number);
            myGoodsList.add(goods);

        } else if ("removeCard".equals(type)) {
            int id = Integer.parseInt(request.getParameter("goodId"));
            myGoodsList.removeIf(v->v.getId()==id);
        }
        response.sendRedirect("ShopCard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
