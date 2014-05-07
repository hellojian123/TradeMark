package com.isoft.web;

import com.google.gson.Gson;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 14-5-7.
 */
public class AdminGetTrademarkByIdServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
        int id=Integer.parseInt(request.getParameter("id"));
        TrademarkService ts=new TrademarkService();
        response.setContentType("application/x-javascript;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            Trademark trademark=ts.getById(id);
            if(trademark!=null){
                Gson gson=new Gson();
                out.println(gson.toJson(trademark).toString());
                return;
            }
            out.print("获取数据失败，请稍后再试...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }

    }
}
