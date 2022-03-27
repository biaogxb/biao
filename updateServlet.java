package com.fruit.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.Impl.FruitDAOImpl;
import com.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/update.do")
public class updateServlet extends ViewBaseServlet {
    FruitDAO fruitDAO = new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fidstr = req.getParameter("fid");
        int fid = Integer.parseInt(fidstr);
        String fname = req.getParameter("fname");
        String pricestr = req.getParameter("price");
        int price = Integer.parseInt(pricestr);
        String fcountstr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountstr);
        String remark = req.getParameter("remark");
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));
        //super.processTemplate("/index",req,resp);
        resp.sendRedirect("index");
    }
}
