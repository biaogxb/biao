package com.fruit.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.Impl.FruitDAOImpl;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del.do")
public class delServlet extends ViewBaseServlet {
    FruitDAO fruit = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr = req.getParameter("fid");
        int fid = Integer.parseInt(fidstr);
        fruit.delFruit(fid);
        resp.sendRedirect("index");
    }
}
