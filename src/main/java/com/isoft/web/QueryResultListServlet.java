package com.isoft.web;

import com.isoft.bean.PageModel;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

		int selectTN = Integer.parseInt(request.getParameter("selectTN"));		//商品名称的模糊查询类型(0前包含,1精确,2包含)
		int selectCHPN = Integer.parseInt(request.getParameter("selectCHPN"));	//申请人名称(中文)的模糊查询类型(0前包含,1精确,2包含)
		int selectENGPN = Integer.parseInt(request.getParameter("selectENGPN"));//申请人名称(英文)的模糊查询类型(0前包含,1精确,2包含)

		request.setAttribute("applyNum",applyNum);
		request.setAttribute("trademarkName",trademarkName);
		request.setAttribute("applicantNameZh",applicantNameZh);
		request.setAttribute("applicantNameEn",applicantNameEn);
		request.setAttribute("selectTN",selectTN);
		request.setAttribute("selectCHPN",selectCHPN);
		request.setAttribute("selectENGPN",selectENGPN);

        TrademarkService ts=new TrademarkService();
        int total=0;
        List<Trademark> trademarkList=null;

        int currentPage=Integer.parseInt((request.getParameter("currentPage") == null || request.getParameter("currentPage").trim().equals("")) ? "1" : request.getParameter("currentPage"));
        int pageSize=10;//每页显示的条数
        PageModel<Trademark> pm=null;
        int type=-1;
        if(applyNum!=null&&!applyNum.trim().equals("")){
            request.setAttribute("applyNum",applyNum);
            Trademark trademark=ts.findByApplyNum(applyNum);
			if(trademark!=null){
				request.setAttribute("trademark",trademark);
			}
            request.setAttribute("classificationNum",classificationNum);
			request.getRequestDispatcher("/WEB-INF/page/queryRegNumResultsList.jsp").forward(request,response);
			return;
		}

		/*按商标名称分页查询*/
		if(trademarkName!=null&&!trademarkName.trim().equals("")){
			String sqlQueryFeild = "trademarkName";
			total = ts.getTotalByCondition(sqlQueryFeild,trademarkName,selectTN);
			pm = new PageModel<Trademark>(total,pageSize);
			if(currentPage>pm.getMaxPage()){
				currentPage=pm.getMaxPage();
			}
			trademarkList=ts.pageGetTrademarks(pageSize, currentPage,sqlQueryFeild,trademarkName,selectTN);
			type=selectTN;
		}

		/*按申请人名称(中文)分页查询*/
		if(applicantNameZh!=null&&!applicantNameZh.trim().equals("")){
			String sqlQueryFeild = "applicantNameZh";
			total = ts.getTotalByCondition(sqlQueryFeild,applicantNameZh,selectCHPN);
			pm = new PageModel<Trademark>(total,pageSize);
			if(currentPage>pm.getMaxPage()){
				currentPage=pm.getMaxPage();
			}
			trademarkList=ts.pageGetTrademarks(pageSize, currentPage,sqlQueryFeild,applicantNameZh,selectCHPN);
			type=selectCHPN;
		}

		/*按申请人名称(英文)分页查询*/
		if(applicantNameEn!=null&&!applicantNameEn.trim().equals("")){
			String sqlQueryFeild = "applicantNameEn";
			total = ts.getTotalByCondition(sqlQueryFeild,applicantNameEn,selectENGPN);
			pm = new PageModel<Trademark>(total,pageSize);
			if(currentPage>pm.getMaxPage()){
				currentPage=pm.getMaxPage();
			}
			trademarkList=ts.pageGetTrademarks(pageSize, currentPage,sqlQueryFeild,applicantNameEn,selectENGPN);
			type=selectENGPN;
		}

        pm.setResult(trademarkList);
		pm.setCurPage(currentPage);
        request.setAttribute("pm",pm);
        request.setAttribute("type",type);
		request.getRequestDispatcher("/WEB-INF/page/generalQueryResultList.jsp").forward(request, response);
	}
}
