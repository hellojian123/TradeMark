package com.isoft.web;


import com.isoft.bean.Trademark;
import com.isoft.service.AdminService;
import com.isoft.service.FindTradeDetailService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 14-5-9.
 */
public class updatePwdServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");
        String userId=request.getParameter("userId");
        Integer id=Integer.parseInt(userId);
        String newpwd=request.getParameter("newpwd");
        String oldpwd=request.getParameter("oldpwd");
        AdminService adminService=new AdminService();
        PrintWriter out = response.getWriter();
        if (adminService.updatePwd(newpwd,oldpwd,id)){
            out.write("0");
        }else {
            out.write("1");
        }

    }
}
