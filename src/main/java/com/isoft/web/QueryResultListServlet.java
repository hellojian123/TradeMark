package com.isoft.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hejian on 14-5-7.
 */
public class QueryResultListServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classificationNum = request.getParameter("classificationNum");		//国际分类号
		String applyNum = request.getParameter("applyNum");							//注册号/申请号
		String trademarkName = request.getParameter("trademarkName");				//商标名称
		String applicantNameZh = request.getParameter("applicantNameZh");			//申请人名称(中文)
		String applicantNameEn = request.getParameter("applicantNameEn");			//申请人名称(英文)

		Integer selectTN = Integer.parseInt(request.getParameter("selectTN"));		//商品名称的模糊查询类型(0前包含,1精确,2包含)
		Integer selectCHPN = Integer.parseInt(request.getParameter("selectCHPN"));	//申请人名称(中文)的模糊查询类型(前包含,精确,包含)
		Integer selectENGPN = Integer.parseInt(request.getParameter("selectENGPN"));//申请人名称(英文)的模糊查询类型(0前包含,1精确,2包含)

		request.setAttribute("applyNum",applyNum);
		request.setAttribute("trademarkName",trademarkName);
		request.setAttribute("applicantNameZh",applicantNameZh);
		request.setAttribute("applicantNameEn",applicantNameEn);
		request.setAttribute("selectTN",selectTN);
		request.setAttribute("selectCHPN",selectCHPN);
		request.setAttribute("selectENGPN",selectENGPN);
		if(applyNum!=null&&!(applyNum.trim().equals(""))){
			request.setAttribute("classificationNum",classificationNum);
			request.getRequestDispatcher("/WEB-INF/page/queryRegNumResultsList.jsp").forward(request,response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/page/generalQueryResultList.jsp").forward(request,response);
	}
}
