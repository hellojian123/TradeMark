package com.isoft.web;

import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by HALOBING on 14-5-8.
 */
public class AdminDeleteTrademarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
        String ids=request.getParameter("ids");
        TrademarkService ts=new TrademarkService();
        PrintWriter out=response.getWriter();
        if(ts.deleteObj(ids)==1){out.write("删除成功！");}else {out.write("删除失败！");}
        out.flush();
        out.close();
    }
}
