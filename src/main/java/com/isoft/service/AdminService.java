package com.isoft.service;

import com.isoft.bean.NewsTemplate;
import com.isoft.bean.User;
import com.isoft.dao.AdminDao;
import com.isoft.util.ServiceUtils;

import java.util.List;

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

	public List<NewsTemplate> getPosteresByType(String type) {
		if(type==null||type.trim().equals("")){
			return null;
		}
		return adminDao.findPosterAll(type);
	}

	public boolean updateNewsAndPoster(NewsTemplate nt) {
		if(nt==null){
			return false;
		}

		return adminDao.updateNews(nt);
	}

	public NewsTemplate getPosterById(Integer id) {
		if(id==null){
			return null;
		}
		return adminDao.findPoster(id);
	}


}
