package com.isoft.bean;

import java.util.Date;

/**
 * Created by admin on 14-5-4.
 */
public class Trademark {
    /**商标标识，自动增长id**/
    private Integer id;
    /**注册号/申请号**/
    private String applyNum;
    /**国际分类号**/
    private int classificationNum;
    /**申请日期**/
    private Date applyDate;
    /**申请人名称（中文）**/
    private String applicantNameZh;
    /**申请人名称（英文）**/
    private String applicantNameEn;
    /**申请人地址（中文）**/
    private String applicantAddressZh;
    /**申请人地址（英文）**/
    private String applicantAddressEn;
    /**商标图像**/
    private String imgPath;
    /**商品/服务列表**/
    private String  servicesList;
    /**类似群**/
    private int similarGroup;
    /**初审公告期号**/
    private String firstNoticeNum;
    /**注册公告期号**/
    private String registerNoticeNum;
    /**初审公告日期**/
    private Date firstNoticeDate;
    /**注册公告日期**/
    private Date registerNoticeDate;
    /**专用权期限开始日期**/
    private Date exclusiveRightStartDate;
    /**专用权期限结束日期**/
    private Date exclusiveRightEndDate;
    /**后期指定日期**/
    private Date afterNamedDate;
    /**国际注册日期**/
    private Date internationalRegisterDate;
    /**优先权日期**/
    private Date priorityDate;
    /**代理人名称**/
    private String agentName;
    /**指定颜色**/
    private String specifyColor;
    /**商标类型**/
    private String trademarkType;
    /**是否共有商标**/
    private boolean share;
    /**备注**/
    private String remarks;
    /**商标流程**/
    private String trademarkProcess;

    /** 商标注册名 **/
    private String trademarkName;

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }

    public int getClassificationNum() {return classificationNum;}

    public void setClassificationNum(int classificationNum) {this.classificationNum = classificationNum; }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplicantNameZh() {
        return applicantNameZh;
    }

    public void setApplicantNameZh(String applicantNameZh) {
        this.applicantNameZh = applicantNameZh;
    }

    public String getApplicantNameEn() {
        return applicantNameEn;
    }

    public void setApplicantNameEn(String applicantNameEn) {
        this.applicantNameEn = applicantNameEn;
    }

    public String getApplicantAddressZh() {
        return applicantAddressZh;
    }

    public void setApplicantAddressZh(String applicantAddressZh) {
        this.applicantAddressZh = applicantAddressZh;
    }

    public String getApplicantAddressEn() {
        return applicantAddressEn;
    }

    public void setApplicantAddressEn(String applicantAddressEn) {
        this.applicantAddressEn = applicantAddressEn;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        imgPath = imgPath;
    }

    public String getServicesList() {
        return servicesList;
    }

    public void setServicesList(String servicesList) {
        this.servicesList = servicesList;
    }

    public int getSimilarGroup() {
        return similarGroup;
    }

    public void setSimilarGroup(int similarGroup) {
        this.similarGroup = similarGroup;
    }

    public String getFirstNoticeNum() {
        return firstNoticeNum;
    }

    public void setFirstNoticeNum(String firstNoticeNum) {
        this.firstNoticeNum = firstNoticeNum;
    }

    public String getRegisterNoticeNum() {
        return registerNoticeNum;
    }

    public void setRegisterNoticeNum(String registerNoticeNum) {
        this.registerNoticeNum = registerNoticeNum;
    }

    public Date getFirstNoticeDate() {
        return firstNoticeDate;
    }

    public void setFirstNoticeDate(Date firstNoticeDate) {
        this.firstNoticeDate = firstNoticeDate;
    }

    public Date getRegisterNoticeDate() {
        return registerNoticeDate;
    }

    public void setRegisterNoticeDate(Date registerNoticeDate) {
        this.registerNoticeDate = registerNoticeDate;
    }

    public Date getExclusiveRightStartDate() {
        return exclusiveRightStartDate;
    }

    public void setExclusiveRightStartDate(Date exclusiveRightStartDate) {
        this.exclusiveRightStartDate = exclusiveRightStartDate;
    }

    public Date getExclusiveRightEndDate() {
        return exclusiveRightEndDate;
    }

    public void setExclusiveRightEndDate(Date exclusiveRightEndDate) {
        this.exclusiveRightEndDate = exclusiveRightEndDate;
    }

    public Date getAfterNamedDate() {
        return afterNamedDate;
    }

    public void setAfterNamedDate(Date afterNamedDate) {
        this.afterNamedDate = afterNamedDate;
    }

    public Date getInternationalRegisterDate() {
        return internationalRegisterDate;
    }

    public void setInternationalRegisterDate(Date internationalRegisterDate) {
        this.internationalRegisterDate = internationalRegisterDate;
    }

    public Date getPriorityDate() {
        return priorityDate;
    }

    public void setPriorityDate(Date priorityDate) {
        this.priorityDate = priorityDate;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getSpecifyColor() {
        return specifyColor;
    }

    public void setSpecifyColor(String specifyColor) {
        this.specifyColor = specifyColor;
    }

    public String getTrademarkType() {
        return trademarkType;
    }

    public void setTrademarkType(String trademarkType) {
        this.trademarkType = trademarkType;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTrademarkProcess() {
        return trademarkProcess;
    }

    public void setTrademarkProcess(String trademarkProcess) {
        this.trademarkProcess = trademarkProcess;
    }
}
