package com.isoft.web;

import com.isoft.bean.PageModel;
import com.isoft.bean.Trademark;
import com.isoft.service.TrademarkService;
import com.isoft.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by admin on 14-5-5.
 */
public class AdminAddOrUpdateTrademarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebUtils.checkSession(request, response, "admin", "/goAdmin.jsp");   //检查session中是否有admin。有则为admin登陆状态。
        Trademark trademark= WebUtils.request2Bean(request, Trademark.class);
        TrademarkService ts=new TrademarkService();
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Trademark oldTrademark=ts.getById(trademark.getId());
            if(ts.saveOrUpdate(trademark)){
                if(trademark.getId()==0){
                    out.write("保存成功！");
                }else{
                    //如果用户改变图片，则删除上一张商标图片
                    if(trademark.getImgPath()!=null&&oldTrademark.getImgPath()!=null&&!trademark.getImgPath().equals(oldTrademark.getImgPath())){
                        String path=request.getSession().getServletContext().getRealPath(oldTrademark.getImgPath());
                        String newImgSrc=path.replace("/", File.separator).replace("\\", File.separator);//处理不同系统 文件夹路径分隔符不同的问题
                        File file=new File(newImgSrc);
                        if(file.exists()){
                            file.delete();
                        }
                    }
                    out.write("修改成功！");
                }
                return ;
            }
            out.write("操作失败！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
        //paging
        int currentPage=Integer.parseInt((request.getParameter("currentPage") == null||"".equals(request.getParameter("currentPage"))) ? "1" : request.getParameter("currentPage"));
        int pageSize=3;//每页显示的条数
        int totalCount=ts.getTotalCount();
        PageModel<Trademark> pm=new PageModel<Trademark>(totalCount,pageSize);
        if(currentPage>pm.getMaxPage()){
            currentPage=pm.getMaxPage();
        }
        List<Trademark> list= ts.pagingBySql(pageSize,currentPage);
        pm.setResult(list);
        request.setAttribute("pm", pm);
        request.setAttribute("currentPage",currentPage);
        request.getRequestDispatcher("/WEB-INF/admin/trademarkManage.jsp").forward(request,response);

    }
}
