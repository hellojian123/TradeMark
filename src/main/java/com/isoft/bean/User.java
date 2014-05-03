package com.isoft.bean;

import java.util.Date;

/**
 * Created by hejian on 14-5-2.
 */
public class User {
	private Integer id;
	private String  name;   		//会员真实姓名
	private String username;		//用户名
	private String password;		//密码  MD5  E10ADC3949BA59ABBE56E057F20F883E   //123456  MD5 Base64 4QrcOUm6Wau+VuBX8g+IPg==
	private String email;			//电子邮件
	private String telephone;		//手机
	private String homePhone;		//座机
	private String fax;				//传真
	private Date lastLoginTime; 	//上次登录时间
	private Date currentLoginTime;  //当前登录时间
	private String lastLoginIp;  	//上次登录ip
	private String currentLoginIp;  //本次登陆ip
	private Integer loginNum; 		//登陆次数
	private Integer userType;		//用户类型	0普通会员	1钻石VIP	2黄金VIP  3铂金VIP
	private Date registerDate;		//注册日期
	private Integer adminType; 		//管理员类型	0非管理员 1管理员	2超级管理员

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}

	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getCurrentLoginIp() {
		return currentLoginIp;
	}

	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}

	public Integer getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getAdminType() {
		return adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}
}
