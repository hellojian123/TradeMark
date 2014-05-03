package com.isoft.web;

import com.isoft.bean.User;
import com.isoft.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by hejian on 14-5-2.
 */
public class AdminLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminService adminService = new AdminService();
		User user = adminService.adminLogin(username,password);
		if(user==null){
			request.setAttribute("error","用户名或密码错误");
			request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request,response);
			return;
		}
		if(user.getAdminType()==0){
			request.setAttribute("error", "您只是普通用户,没有权限进入后台管理系统！");
			request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request,response);
		}
		user.setLoginNum(user.getLoginNum()+1);
		user.setLastLoginTime(user.getCurrentLoginTime());
		user.setCurrentLoginTime(new Date());
		user.setLastLoginIp(user.getCurrentLoginIp());
		user.setCurrentLoginIp(request.getRemoteAddr());
		adminService.updateAdmin(user);
		request.getSession().setAttribute("admin", user);
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request,response);
	}
}
