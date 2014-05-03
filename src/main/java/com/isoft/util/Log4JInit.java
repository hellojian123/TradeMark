package com.isoft.util;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.net.MalformedURLException;

/**
 * Created by hejian on 14-5-2.
 */
public class Log4JInit extends HttpServlet {
	@Override
	public void init() throws ServletException {

		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource(getServletConfig().getInitParameter("log4j_name")));
	}
}
