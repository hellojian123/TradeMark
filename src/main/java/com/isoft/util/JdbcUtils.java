package com.isoft.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hejian on 14-4-30.
 */
public class JdbcUtils {

	//使用c3p0连接池
	private static ComboPooledDataSource ds = null;
	private static ThreadLocal<Connection> threadLocal= new ThreadLocal<Connection>();
	static{
		try {
			ds = new ComboPooledDataSource("mysql");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * 获得数据库连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds;
	}

	/**
	 *
	 * @return 获得数据库连接
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		Connection conn = threadLocal.get();
		try{
			if(conn==null){
				conn =  getDataSource().getConnection();
				threadLocal.set(conn);
			}
			return conn;
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 释放数据库链接资源
	 */
	public static void release(){
		Connection conn = threadLocal.get();
		try{
			if(conn!=null){
				conn.close();
				threadLocal.remove(); //解除当前线程上绑定conn
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 开启事物
	 */
	public static void beginTransaction(){
		Connection conn = threadLocal.get();
		try {
			if(conn == null){
				conn = getConnection();
				threadLocal.set(conn);   //将conn绑定到当前线程中
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit(){
		Connection conn =  threadLocal.get();
		try{
			if(conn!=null){
				conn.commit();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 事物回滚
	 */
	public static void rollback(){
		Connection conn =  threadLocal.get();
		try{
			if(conn!=null){
				conn.rollback();
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
