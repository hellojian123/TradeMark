package com.isoft.bean;

/**
 * Created by hejian on 14-5-4.
 * 新闻和广告图片模板
 * 对应 t_newsandposter表
 */
public class NewsTemplate {
	private Integer id;
	private String title;  		//图片标题
	private String imgUrl;	    //图片地址
	private String newsLink; 	//图片所指向的链接
	private Integer type; 		//图片类型
	private Integer isStatus;	//广告招商   1： 已经招商，0：未招商

	public Integer getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(Integer isStatus) {
		this.isStatus = isStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
