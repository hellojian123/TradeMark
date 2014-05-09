package com.isoft.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isoft.bean.PageModel;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

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
        PrintWriter out=response.getWriter();
        Trademark trademark=ts.getById(id);
        if(trademark!=null){
            Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();//格式化日期，否则页面显示格式为 ："五月 9, 2014" ，修改后保存 日期强制转换异常
            out.print(gson.toJson(trademark).toString());
        }else{
            out.print("获取数据失败，请稍后再试...");
        }
        request.setAttribute("currentPage",request.getAttribute("currentPage"));
        out.flush();
        out.close();

    }
}
