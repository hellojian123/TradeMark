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
        TrademarkService ts=new TrademarkService();
        int total=0;
        List<Trademark> trademarkList=null;
        int currentPage=Integer.parseInt((request.getParameter("currentPage") == null) ? "1" : request.getParameter("currentPage"));
        int pageSize=1;//每页显示的条数
        PageModel<Trademark> pm=null;
        int type=-1;
        if(applyNum!=null&&!applyNum.trim().equals("")){
            request.setAttribute("applyNum",applyNum);
            Trademark trademark=ts.findByApplyNum(applyNum);
            request.setAttribute("trademark",trademark);
            request.setAttribute("classificationNum",classificationNum);
			request.getRequestDispatcher("/WEB-INF/page/queryRegNumResultsList.jsp").forward(request,response);
			return;
		}


        if (trademarkName!=null&&!trademarkName.trim().equals("")&&selectTN==1){//精确查询商标名
            total=ts.getTotalByTradeName(trademarkName);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            type=selectTN;
            trademarkList=ts.pagingTNameBySql(pageSize, currentPage, trademarkName);
        }
        if(trademarkName!=null&&!trademarkName.trim().equals("")&&(selectTN==0||selectTN==2)){//模糊查询商标名
            total=ts.getTotalByLikeTradeName(trademarkName);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            trademarkList=ts.pagingLikeTNameBySql(pageSize, currentPage, trademarkName);
            type=selectTN;
        }
        if (applicantNameZh!=null&&!applicantNameZh.trim().equals("")&&selectCHPN==1){//精确中文名查询
            total=ts.getTotalByCHPName(applicantNameZh);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            trademarkList=ts.pagingCHNameBySql(pageSize, currentPage, applicantNameZh);
            type=selectTN;
        }
        if (applicantNameZh!=null&&!applicantNameZh.trim().equals("")&&(selectCHPN==0||selectCHPN==2)){//模糊中文名查询
            total=ts.getTotalByLikeCHPName(applicantNameZh);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            trademarkList=ts.pagingLikeCHNameBySql(pageSize, currentPage, applicantNameZh);
            type=selectTN;
        }

        if (applicantNameEn!=null&&!applicantNameEn.trim().equals("")&&selectENGPN==1){//精确en名查询
            total=ts.getTotalByENGPName(applicantNameEn);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            trademarkList=ts.pagingENNameBySql(pageSize, currentPage, applicantNameEn);
            type=selectTN;
        }
        if (applicantNameEn!=null&&!applicantNameEn.trim().equals("")&&(selectENGPN==0||selectENGPN==2)){//模糊en名查询
            total=ts.getTotalByENGPName(applicantNameEn);
            pm=new PageModel<Trademark>(total,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            trademarkList=ts.pagingLikeENNameBySql(pageSize, currentPage, applicantNameEn);
            type=selectTN;
        }
        pm.setResult(trademarkList);
        request.setAttribute("pm",pm);
        request.setAttribute("type",type);
		request.getRequestDispatcher("/WEB-INF/page/generalQueryResultList.jsp").forward(request, response);

	}
}
