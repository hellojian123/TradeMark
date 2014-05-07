package com.isoft.web;

import com.isoft.bean.Trademark;
import com.isoft.service.FindTradeDetailService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 14-5-7.
 */
public class TrademarkDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  tempid=request.getParameter("id");
        Integer id= Integer.parseInt(tempid);
        FindTradeDetailService fds=new FindTradeDetailService();
        Trademark tm=fds.findTrademarkDetailById(id);
        request.setAttribute("tm",tm);
        request.getRequestDispatcher("/WEB-INF/page/trademarkDetail.jsp").forward(request,response);
    }
}
