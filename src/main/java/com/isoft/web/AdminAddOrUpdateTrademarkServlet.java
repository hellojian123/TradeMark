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
        PrintWriter out = response.getWriter();
        Trademark oldTrademark=ts.getById(trademark.getId());//根据id获取数据库中的imgPath
        if(ts.saveOrUpdate(trademark)){
            if(trademark.getId()==0){//如果id=0即客户端未提交id，执行保存操作
                out.print("保存成功！");
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
                out.print("修改成功！");
            }

        }else{
            out.print("操作失败！");
        }
        request.setAttribute("currentPage",request.getAttribute("currentPage"));
        out.flush();
        out.close();
    }
}
