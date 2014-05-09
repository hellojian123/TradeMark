package com.isoft.dao;

import com.isoft.bean.NewsTemplate;
import com.isoft.bean.User;
import com.isoft.util.DaoUtils;
import com.isoft.util.ServiceUtils;

import java.sql.SQLException;
import java.util.List;

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

	public List<NewsTemplate> findPosterAll(String type) {
		if(type==null||type.trim().equals("")){
			return null;
		}
		String sql = "select * from t_newsandposter where type = ?";
		try {
			return DaoUtils.findAll(sql,NewsTemplate.class,type);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateNews(NewsTemplate nt) {
		if(nt==null){
			return false;
		}
		String sql = "update t_newsandposter set title=?, imgUrl=?, newsLink=?, type=?, isStatus=? where id = ?";
		try {
			DaoUtils.update(sql,
					nt.getTitle(),
					nt.getImgUrl(),
					nt.getNewsLink(),
					nt.getType(),
					nt.getIsStatus(),
					nt.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public NewsTemplate findPoster(Integer id) {
		if(id==null){
			return null;
		}
		String sql = "select * from t_newsandposter where id = ?";
		try{
			return DaoUtils.find(sql,NewsTemplate.class,id);
		}catch (Exception e){
			return null;
		}

	}
    /**
     * 修改密码
     */
    public boolean updatePWD(String newpwd,String oldpwd,Integer id){
        try{
                String tempnewpwd=ServiceUtils.MD5(newpwd);
                String tempoldpwd=ServiceUtils.MD5(oldpwd);
                String sql="select * from t_user where id=?";
                User user=DaoUtils.find(sql,User.class,id);
                if (tempoldpwd.equals(user.getPassword())){
                    String upsql="UPDATE t_user set password =? where id=?";
                    DaoUtils.update(upsql,tempnewpwd,id);
                    return true;
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
