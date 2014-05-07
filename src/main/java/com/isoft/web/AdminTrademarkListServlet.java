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
 * Created by admin on 14-5-5.
 */
public class AdminTrademarkListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。

        int currentPage=Integer.parseInt((request.getParameter("currentPage") == null) ? "1" : request.getParameter("currentPage"));
        int pageSize=1;//每页显示的条数
        TrademarkService ts=new TrademarkService();
        int totalCount=ts.getTotalCount();
        PageModel<Trademark> pm=new PageModel<Trademark>(totalCount,pageSize);
        if(currentPage>pm.getMaxPage()){
            currentPage=pm.getMaxPage();
        }
        List<Trademark> list= ts.pagingBySql(pageSize,currentPage);
        pm.setResult(list);
        request.setAttribute("pm", pm);
        request.getRequestDispatcher("/WEB-INF/admin/trademarkManage.jsp").forward(request,response);

    }
}
