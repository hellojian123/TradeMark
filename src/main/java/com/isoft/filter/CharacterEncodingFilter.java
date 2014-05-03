package com.isoft.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hejian on 14-5-2.
 * 解决全站中文乱码
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig config = null;
	private String defaultCharset = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		String charset = config.getInitParameter("charset");
		if(charset == null){
			charset = defaultCharset;
		}

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;

		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);

		final String tempCharset = charset;
		/**
		 * this.getClass().getClassLoader() 代理所使用的类装载器
		 * request.getClass().getInterfaces() 代理哪个的接口，这里是代理request的接口
		 */
		filterChain.doFilter((ServletRequest) Proxy.newProxyInstance(this.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
			/**
			 * @proxy 当前代理对象
			 * @method 代理对象当前调用的方法
			 * @args 方法参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(!method.getName().equals("getParameter")){
					/**
					 *  invoke(Object obj, Object... args)
					 *  @obj 从哪个对象调用这个方法，这里是request对象调用
					 *  @args 方法调用的参数
					 */
					return method.invoke(request,args);
				}
				if(!request.getMethod().equalsIgnoreCase("get")){
					return method.invoke(request,args);
				}
				String value = (String) method.invoke(request, args);
				if(value==null){
					return null;
				}

				return new String(value.getBytes("ISO-8859-1"), tempCharset);
			}
		}),response);

	}

	@Override
	public void destroy() {

	}
}
