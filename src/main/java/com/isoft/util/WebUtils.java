package com.isoft.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * web层工具类
 */
public class WebUtils {
	/**
	 * 检查session中的指定属性，不存在则重定向到指定页面
	 * @param request
	 * @param name 需要检查的session中属性的名称
	 * @param path 如果不存在 所跳转的指定页面
	 */
	public static void checkSession(HttpServletRequest request,HttpServletResponse response,String name,String path){
		HttpSession session = request.getSession();
		if(session==null){
			try {
				request.getRequestDispatcher(path).forward(request,response);
				return;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		Object obj = session.getAttribute(name);
		if(obj==null){
			try {
				request.getRequestDispatcher(path).forward(request,response);
				return;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return;
	}

	/**
	 * 将request参数分装到相应的bean中
	 * @param request
	 * @param clazz 需要封装bean的class
	 * @param <T>
	 * @return 返回所封装的bean
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()){
				String name = e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean,name,value);
			}
			return bean;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
