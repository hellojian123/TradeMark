package com.isoft.web;

import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 14-5-8.
 */
public class AdminLikeSearchTrademarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");

        String trademarkName=request.getParameter("trademarkNameSearchVal");
        TrademarkService ts=new TrademarkService();
    }
}
