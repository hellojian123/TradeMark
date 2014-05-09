package com.isoft.web;

import com.isoft.bean.PageModel;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

        List<Trademark> list=ts.AdminLikeSearch(trademarkName);
        int currentPage=Integer.parseInt((request.getParameter("currentPage") == null||"".equals(request.getParameter("currentPage"))) ? "1" : request.getParameter("currentPage"));
        int pageSize=3;//每页显示的条数
        int totalCount=ts.getTotalCount();
        PageModel<Trademark> pm=new PageModel<Trademark>(totalCount,pageSize);
        pm.setResult(list);
        request.setAttribute("pm", pm);
        request.setAttribute("searchVal",trademarkName);
        request.setAttribute("currentPage",currentPage);
        request.getRequestDispatcher("/WEB-INF/admin/trademarkManage.jsp").forward(request,response);
    }
}
