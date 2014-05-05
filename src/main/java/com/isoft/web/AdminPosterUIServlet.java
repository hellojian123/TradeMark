package com.isoft.web;

import com.isoft.bean.NewsTemplate;
import com.isoft.service.AdminService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hejian on 14-5-4.
 */
public class AdminPosterUIServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtils.checkSession(request,response,"admin","/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
		String type = request.getParameter("type");

		AdminService service = new AdminService();
		List<NewsTemplate> posters = service.getPosteresByType(type);
		request.setAttribute("posters", posters);
		request.setAttribute("type", type);

		request.getRequestDispatcher("/WEB-INF/admin/posterManage.jsp").forward(request,response);

	}
}
