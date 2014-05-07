package com.isoft.web;

import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hejian on 14-5-6.
 */
public class CodeValidationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = WebUtils.getValidateCode(request);
		String validateCode = request.getParameter("validateCode");
		if(code==null||code.trim().equals("")||validateCode==null||validateCode.trim().equals("")){
			response.getWriter().write("1");
			return;
		}
		if(!code.trim().toLowerCase().equals(validateCode.trim().toLowerCase())){
			response.getWriter().write("1");	//验证码输入错误
		}
	}
}
