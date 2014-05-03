package com.isoft.util;

/**
 * Created by hejian on 14-5-2.
 * 单例泛型工厂，用于三层架构的解耦,用于产生service层和dao层的实例
 */
public class BeanFactory {
	private static final BeanFactory instance = new BeanFactory();
	private BeanFactory(){}
	public static BeanFactory getInstance(){
		return instance;
	}


	/**
	 * 创建dao或service。用接口接收返回值
	 * @param className dao或service的实现类的完整类名.如：com.isoft.dao.impl.UserDaoImpl
	 * @param clazz dao或service的接口类型，如：UserDao.class
	 * @param <T> dao或service的接口类型
	 * @return 返回的是dao或service的实例，为了松耦合，用接口接收返回值。
	 */
	@SuppressWarnings("unchecked")
	public <T> T createBean(String className,Class<T> clazz){
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
