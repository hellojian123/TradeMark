package com.isoft.dao;

import com.isoft.bean.Trademark;
import com.isoft.util.DaoUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 14-5-4.
 */
public class TrademarkDao {

    /**
     *   根据商标注册名模糊查询，返回列表
     *   @return List
     */
    public List<Trademark> findByTrademarkLikeName(String trademarkName){
        String sql="select * from t_trademark where trademarkName like %?%";
        try{
            return DaoUtils.findAll(sql,Trademark.class,trademarkName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     *   根据商标注册名查询，返回列表
     *   @return List
     */
    public List<Trademark> findByTrademarkName(String trademarkName){
        String sql="select * from t_trademark where trademarkName = ?";
        try{
            return DaoUtils.findAll(sql,Trademark.class,trademarkName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     *  根据商标注册号查询，返回trademark对象
     * @param applyNum
     * @return trademark
     */
    public Trademark findByApplyNum(String applyNum){
        String sql="select * from t_trademark where applyNum= ?";
        try {
            return  DaoUtils.find(sql,Trademark.class,applyNum);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /**
     *  根据商标注册人中文模糊查询
     * @param applicantNameZh
     * @return
     */
    public List<Trademark> findByLikeApplicantNameZh(String applicantNameZh){
        String sql="select * from t_trademark where applicantNameZh like %?%";
        try{
            return DaoUtils.findAll(sql,Trademark.class,applicantNameZh);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  根据商标注册人中文名精确查询
     * @param applicantNameZh
     * @return
     */
    public List<Trademark> findByApplicantNameZh(String applicantNameZh){
        String sql="select * from t_trademark where applicantNameZh =?";
        try{
            return DaoUtils.findAll(sql, Trademark.class,applicantNameZh);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     *  根据商标注册人en文模糊查询
     * @param applicantNameEn
     * @return
     */
    public List<Trademark> findByLikeApplicantNameEn(String applicantNameEn){
        String sql="select * from t_trademark where applicantNameEh like %?%";
        try{
            return DaoUtils.findAll(sql,Trademark.class,applicantNameEn);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  根据商标注册人en文名精确查询
     * @param applicantNameEn
     * @return
     */
    public List<Trademark> findByApplicantNameEn(String applicantNameEn){
        String sql="select * from t_trademark where applicantNameEn =?";
        try{
            return DaoUtils.findAll(sql, Trademark.class,applicantNameEn);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     *
     *  根据注册号/申请号   国际分类号 查询商标信息
     * @return
     */
    public Trademark findApNumClsfNum(String applyNum,int classificationNum){
        String sql="select * from t_trademark where applyNum=? and classificationNum=?";
        try {
            return DaoUtils.find(sql,Trademark.class,applyNum,classificationNum);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     *  根据分类号，注册号、商标名查询
     */
    public Trademark findApNumClsfTmName(String applyNum,int classificationNum,String trademarkName){
        String sql="select * from t_trademark where applyNum=? and classificationNum=? and trademarkName=?";
        try{
            return DaoUtils.find(sql,Trademark.class,applyNum,classificationNum,trademarkName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据分类号、注册号、商标名称、申请人中文名称查询
     */
    public Trademark findApClsfTmNameZh(String applyNum,int classificationNum,String trademarkName,String applicantNameZh){
        String sql="select * from t_trademark where applyNum=? and classificationNum=? and trademarkName=? and applicantNameZh=?";
        try{
            return DaoUtils.find(sql,Trademark.class,applyNum,classificationNum,trademarkName,applicantNameZh);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据分类号、注册号、商标名称、申请人中文名、英文名查询
     */
    public Trademark findApClsfTmNameZhEn(String applyNum,int classificationNum,String trademarkName,String applicantNameZh,String applicantNameEn){
        String sql="select * from t_trademark where applyNum=? and classificationNum=? and trademarkName=? and applicantNameZh=? and applicantNameEn=?";
        try{
            return DaoUtils.find(sql,Trademark.class,applyNum,classificationNum,trademarkName,applicantNameZh,applicantNameEn);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据分类号、注册号、商标名称、申请人英文名称查询
     */
    public Trademark findApClsfTmEn(String applyNum,int classificationNum,String trademarkName,String applicantNameEn){
        String sql="select * from t_trademark where applyNum=? and classificationNum=? and trademarkName=? and applicantNameEn=?";
        try{
            return DaoUtils.find(sql,Trademark.class,applyNum,classificationNum,trademarkName,applicantNameEn);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 根据注册号、商标名查询
     */
    public Trademark findApTm(String applyNum,String trademarkName){
        String sql="select * from t_trademark where applyNum =? and trademarkName=?";
        try {
            return DaoUtils.find(sql,Trademark.class,applyNum,trademarkName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页
     * @param pageSize 每页显示的条数
     * @param currentPage 当前页
     * @return
     */
    public List<Trademark> pagingBySql(int pageSize, int currentPage){
        try {
            String sql="select * from t_trademark limit ?,?";
            return DaoUtils.findAll(sql, Trademark.class, pageSize * (currentPage - 1), pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存商标信息
     * @param trademark
     */
    public void save(Trademark trademark){
        try {
            String sql="INSERT INTO t_trademark(applyNum,classificationNum,trademarkName,applyDate,applicantNameZh,"+"" +
                    "applicantNameEn,applicantAddressZh,applicantAddressEn,imgPath,servicesList,similarGroup,firstNoticeNum,"+"" +
                    "registerNoticeNum,firstNoticeDate,registerNoticeDate,exclusiveRightStartDate,exclusiveRightEndDate,"+"" +
                    "afterNamedDate,internationalRegisterDate,priorityDate,agentName,specifyColor,trademarkType,"+"" +
                    "share,remarks,trademarkProcess) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            DaoUtils.update(sql,trademark.getApplyNum(),trademark.getClassificationNum(),trademark.getTrademarkName(),
                    trademark.getApplyDate(),trademark.getApplicantNameZh(),trademark.getApplicantNameEn(),
                    trademark.getApplicantAddressZh(),trademark.getApplicantAddressEn(),trademark.getImgPath(),
                    trademark.getServicesList(),trademark.getSimilarGroup(),trademark.getFirstNoticeNum(),
                    trademark.getRegisterNoticeNum(),trademark.getFirstNoticeDate(),trademark.getRegisterNoticeDate(),
                    trademark.getExclusiveRightStartDate(),trademark.getExclusiveRightEndDate(),trademark.getAfterNamedDate(),
                    trademark.getInternationalRegisterDate(),trademark.getPriorityDate(),trademark.getAgentName(),trademark.getSpecifyColor(),
                    trademark.getTrademarkType(),trademark.isShare(),trademark.getRemarks(),trademark.getTrademarkProcess());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改商标
     * @param trademark
     */
    public void update(Trademark trademark){
        try {
            String sql="UPDATE t_trademark SET applyNum=?,classificationNum=?," +
                    "trademarkName=?,applyDate,applicantNameZh=?,"+"" +
                    "applicantNameEn=?,applicantAddressZh=?,applicantAddressEn=?,imgPath=?," +
                    "servicesList=?,similarGroup=?,firstNoticeNum=?,"+"" +
                    "registerNoticeNum=?,firstNoticeDate=?,registerNoticeDate=?," +
                    "exclusiveRightStartDate=?,exclusiveRightEndDate=?,"+"" +
                    "afterNamedDate=?,internationalRegisterDate=?,priorityDate=?," +
                    "agentName=?,specifyColor=?,trademarkType=?,"+"" +
                    "share=?,remarks=?,trademarkProcess=? WHERE id=?";
            DaoUtils.update(sql,trademark.getApplyNum(),trademark.getClassificationNum(),trademark.getTrademarkName(),
                    trademark.getApplyDate(),trademark.getApplicantNameZh(),trademark.getApplicantNameEn(),
                    trademark.getApplicantAddressZh(),trademark.getApplicantAddressEn(),trademark.getImgPath(),
                    trademark.getServicesList(),trademark.getSimilarGroup(),trademark.getFirstNoticeNum(),
                    trademark.getRegisterNoticeNum(),trademark.getFirstNoticeDate(),trademark.getRegisterNoticeDate(),
                    trademark.getExclusiveRightStartDate(),trademark.getExclusiveRightEndDate(),trademark.getAfterNamedDate(),
                    trademark.getInternationalRegisterDate(),trademark.getPriorityDate(),trademark.getAgentName(),trademark.getSpecifyColor(),
                    trademark.getTrademarkType(),trademark.isShare(),trademark.getRemarks(),trademark.getTrademarkProcess(),trademark.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据id查询一条商标信息
     * @param id
     * @return
     */
    public Trademark getById(int id){
        try {
           return DaoUtils.find("SELECT * FROM t_trademark WHERE id=?",Trademark.class,id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取商标的总记录数
     * @return
     */
    public int getTotalCount(){
        try {
           return DaoUtils.searchCount("t_trademark",Trademark.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

}
