package com.isoft.service;

import com.isoft.bean.User;
import com.isoft.dao.AdminDao;
import com.isoft.util.ServiceUtils;

/**
 * Created by hejian on 14-5-2.
 */
public class AdminService {

	private AdminDao adminDao = new AdminDao();

	public User adminLogin(String username, String password) {
		if(username==null||password==null){
			return null;
		}
		password = ServiceUtils.MD5(password);
		//System.out.println(password+"--------------------");
		return adminDao.find(username,password);
	}

	public void updateAdmin(User user) {
		if(user==null){
			return;
		}
		adminDao.update(user);
	}
}
