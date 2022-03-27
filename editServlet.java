package com.fruit.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.Impl.FruitDAOImpl;
import com.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit.do")
public class editServlet extends ViewBaseServlet {
    FruitDAO fruit = new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr = req.getParameter("fid");
        if(fidstr!=null&&!"".equals(fidstr)){
            int fid = Integer.parseInt(fidstr);
            Fruit fruitByID = fruit.getFruitByID(fid);
            req.setAttribute("fruit",fruitByID);
            super.processTemplate("edit", req, resp);
        }
    }
}
