package com.isoft.listener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hejian on 14-5-5.
 * web初始化监听器，用来在web初始化的时候做一些事情。
 */
public class WebInitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		//注册日期转换器
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				if(value instanceof String){
					String v = (String) value;
					if(v.trim().equals("")){
						return null;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						Date date = sdf.parse(v);
						return date;
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				return null;
				//throw new RuntimeException("类型不是String，无法将其转换为Date类型");
			}
		}, Date.class);


	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {


	}
}
