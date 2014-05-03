package com.isoft.dao;

import com.isoft.bean.User;
import com.isoft.util.DaoUtils;
import java.sql.SQLException;

/**
 * Created by hejian on 14-5-3.
 */
public class AdminDao {
	/**
	 * 通过用户名和密码查询返回一个admin对象
	 * @param username
	 * @param password
	 * @return
	 */
	public User find(String username, String password) {
		String sql = "select * from t_user where username = ? and password = ?";
		try {
			return  DaoUtils.find(sql,User.class,username,password);
		} catch (SQLException e) {
			e.printStackTrace();   //打印异常
			return null;  //如果有异常，返回空的user对象
		}
	}

	/**
	 * 更新admin对象
	 * @param user 新的admin对象
	 */
	public void update(User user) {
		String sql = "update t_user set loginNum=?,lastLoginTime=?,currentLoginTime=?,lastLoginIp=?,currentLoginIp=? where id = ?";

		try {
			DaoUtils.update(sql,
					user.getLoginNum(),
					user.getLastLoginTime(),
					user.getCurrentLoginTime(),
					user.getLastLoginIp(),
					user.getCurrentLoginIp(),
					user.getId());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
