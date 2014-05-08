package com.isoft.web;

import com.google.gson.Gson;
import com.isoft.bean.PageModel;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by admin on 14-5-7.
 */
public class AdminGetTrademarkByIdServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
        /*response.setContentType("application/x-javascript;charset=UTF-8");// 可以自动识别为Json对象，否则eval解析json无效*/
        int id=Integer.parseInt(request.getParameter("id"));
        TrademarkService ts=new TrademarkService();
        PrintWriter out = null;
        out = response.getWriter();
        Trademark trademark = ts.getById(id);

        if (trademark != null) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            request.setAttribute("tid",trademark.getId());
            request.setAttribute("applyNum",trademark.getApplyNum());
            request.setAttribute("classificationNum",trademark.getClassificationNum());
            request.setAttribute("trademarkName",trademark.getTrademarkName());
            request.setAttribute("applyDate",sdf.format(trademark.getApplyDate()));
            request.setAttribute("applicantNameZh",trademark.getApplicantNameZh());
            request.setAttribute("applicantNameEn",trademark.getApplicantNameEn());
            request.setAttribute("applicantAddressZh",trademark.getApplicantAddressZh());
            request.setAttribute("imgPath",trademark.getImgPath());
            request.setAttribute("servicesList",trademark.getServicesList());
            request.setAttribute("similarGroup", trademark.getSimilarGroup());
            request.setAttribute("firstNoticeNum",trademark.getFirstNoticeNum());
            request.setAttribute("registerNoticeNum",trademark.getRegisterNoticeNum());
            request.setAttribute("firstNoticeDate",sdf.format(trademark.getFirstNoticeDate()));
            request.setAttribute("registerNoticeDate",sdf.format(trademark.getFirstNoticeDate()));
            request.setAttribute("exclusiveRightStartDate",sdf.format(trademark.getExclusiveRightStartDate()));
            request.setAttribute("exclusiveRightEndDate",sdf.format(trademark.getExclusiveRightEndDate()));
            if(trademark.getAfterNamedDate()!=null){request.setAttribute("afterNamedDate",sdf.format(trademark.getAfterNamedDate()));}
            if(trademark.getInternationalRegisterDate()!=null){request.setAttribute("internationalRegisterDate",sdf.format(trademark.getInternationalRegisterDate()));}
            if(trademark.getPriorityDate()!=null){request.setAttribute("priorityDate",sdf.format(trademark.getPriorityDate()));}
            request.setAttribute("specifyColor", trademark.getSpecifyColor());
            request.setAttribute("trademarkType",trademark.getTrademarkType());
            request.setAttribute("share",trademark.isShare());
            request.setAttribute("remarks",trademark.getRemarks());
            request.setAttribute("trademarkProcess",trademark.getTrademarkProcess());
            request.setAttribute("currentPage",request.getAttribute("currentPage"));

            //分页信息
            int currentPage=Integer.parseInt((request.getParameter("currentPage") == null) ? "1" : request.getParameter("currentPage"));
            int pageSize=3;//每页显示的条数
            int totalCount=ts.getTotalCount();
            PageModel<Trademark> pm=new PageModel<Trademark>(totalCount,pageSize);
            if(currentPage>pm.getMaxPage()){
                currentPage=pm.getMaxPage();
            }
            List<Trademark> list= ts.pagingBySql(pageSize,currentPage);
            pm.setResult(list);
            request.setAttribute("pm", pm);
        }
        request.getRequestDispatcher("/WEB-INF/admin/trademarkManage.jsp").forward(request,response);


/*        int id=Integer.parseInt(request.getParameter("id"));
        TrademarkService ts=new TrademarkService();
        PrintWriter out=null;
        try {
            out=response.getWriter();
            Trademark trademark=ts.getById(id);
            if(trademark!=null){
                Gson gson=new Gson();
                out.println(gson.toJson(trademark).toString());
                System.out.println(gson.toJson(trademark).toString());
            }else{
                out.println("获取数据失败，请稍后再试...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }*/

    }
}
