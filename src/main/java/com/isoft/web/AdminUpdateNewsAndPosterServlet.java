package com.isoft.web;

import com.isoft.bean.NewsTemplate;
import com.isoft.service.AdminService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by hejian on 14-5-5.
 */
public class AdminUpdateNewsAndPosterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtils.checkSession(request,response,"admin","/goAdmin.jsp");
		NewsTemplate nt = WebUtils.request2Bean(request, NewsTemplate.class);
		AdminService service = new AdminService();
		//在更新的时候先删除原来的图片。然后再更新存储新的地址。
		NewsTemplate poster = service.getPosterById(nt.getId());
		if(poster!=null){
			String pathPic = request.getServletContext().getRealPath("/");
			String imgOldPath = pathPic + poster.getImgUrl();
			File file = new File(imgOldPath);
			if(file.exists()){
				file.delete();
			}
		}

		if(service.updateNewsAndPoster(nt)){
			response.getWriter().write("0");//返回0表示更新成功
			return;
		}else {
			response.getWriter().write("1");//返回1表示更新失败
			return;
		}
	}

}
