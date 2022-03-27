package com.fruit.servlets;

import com.fruit.dao.FruitDAO;
import com.fruit.dao.Impl.FruitDAOImpl;
import com.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/index")
public class indexServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String oper = req.getParameter("oper");
        String keyword = null;
        Integer pageNo = 1;
        HttpSession session = req.getSession();
        if(StringUtil.isNotEmpty(oper)&&"search".equals(oper)){
            pageNo = 1;
            keyword = req.getParameter("keyword");
            session.setAttribute("keyword",keyword);
            if(StringUtil.isEmpty(keyword)){
                keyword = "";
            }
        }else{
            Object keyword1 = session.getAttribute("keyword");
            if(keyword1!=null){
                keyword = (String)keyword1;
            }else{
                keyword = "";
            }
            String pageNostr = req.getParameter("pageNo");
            if(StringUtil.isNotEmpty(pageNostr)){
                pageNo = Integer.parseInt(pageNostr);
            }
        }

        session.setAttribute("pageNo",pageNo);

        FruitDAO Fruit1 = new FruitDAOImpl();
        List<Fruit> fruitList = Fruit1.getFruitList(keyword,pageNo);
        int fruitCount = Fruit1.getFruitCount(keyword);
        int pageCount = (fruitCount+5-1)/5;
        session.setAttribute("pageCount",pageCount);
        session.setAttribute("fruitList",fruitList);
        super.processTemplate("index",req,resp);

    }



}
