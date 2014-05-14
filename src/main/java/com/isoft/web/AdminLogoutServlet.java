package com.isoft.web;

import com.isoft.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 14-5-14.
 */
public class AdminLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("admin");
        if(user!=null){
            request.getSession().removeAttribute("admin");
        }
        request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request,response);
    }
}
