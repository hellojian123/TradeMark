package com.isoft.web;

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
 * Created by admin on 14-5-5.
 */
public class AdminAddOrUpdateTrademarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
        Trademark trademark= WebUtils.request2Bean(request, Trademark.class);
        TrademarkService ts=new TrademarkService();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(ts.saveOrUpdate(trademark)){
                if(trademark.getId()==-1){
                    out.print("保存成功！");
                }else{
                    out.print("修改成功！");
                }
                return ;
            }
            out.print("操作失败！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
        request.getRequestDispatcher("/WEB-INF/admin/trademarkManage.jsp").forward(request,response);

    }
}
