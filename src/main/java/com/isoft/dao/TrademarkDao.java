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
     * 根据id查询出详细的商标信息
     */
    public Trademark findById(Integer id){
        String sql="select * from t_trademark where id =?";
        try {
            return DaoUtils.find(sql,Trademark.class,id);
        }catch (Exception e){
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
                    "trademarkName=?,applyDate=?,applicantNameZh=?,"+"" +
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

    /**
     * By HALOBING at 2014/5/8 16:25
     * 单条删除或批量删除，如果ids包含 , 则执行批量删除,返回 1，操作成功，返回 0 操作失败
     * @param ids
     */
    public int deleteObj(String ids){
        try {
            String sql="delete from t_trademark where id=?";
            if(!ids.contains(",")){
                DaoUtils.update(sql,ids);
                return 1;
            }
            for(String id:ids.split(",")){
                DaoUtils.update(sql,id);
            }
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


	/**
	 * 根据条件查出总数
	 * @param
	 * @param
	 * @return
	 */
	public int getCountByCondition(String sqlQueryfieldName,String condition, Integer selectCondition) {
		if(condition==null||condition.trim().equals("")){
			return 0;
		}
		String likeCondtition = null;
		String sql = "select count(*) from t_trademark where "+sqlQueryfieldName;
		if(selectCondition==0){	//前包含查询
			likeCondtition =" like ?" ;
			condition = condition+"%";
		}
		if(selectCondition==1){	//精确查询
			likeCondtition = " = ?";
		}
		if(selectCondition==2){	//包含查询
			likeCondtition = " like ?";
			condition = "%"+condition+"%";
		}
		sql = sql+likeCondtition;
		try {
		    return DaoUtils.searchCountByCondition(sql,Trademark.class,condition);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 *	根据条件分页查询。注意sql语句间的空格
	 * @param pageSize
	 * @param currentPage
	 * @param sqlQueryFeild
	 *@param queryContent
	 * @param selectCondition   @return
	 */
	public List<Trademark> pagingQueryByCondition(int pageSize, int currentPage, String sqlQueryFeild, String queryContent, int selectCondition){

		String likeCondtition = null;
		String sql = "select * from t_trademark where "+sqlQueryFeild;
		if(selectCondition==0){	//前包含查询
			likeCondtition = " like ?";
			queryContent = queryContent+"%";
		}
		if(selectCondition==1){	//精确查询
			likeCondtition = " = ?";
		}
		if(selectCondition==2){	//包含查询
			likeCondtition = " like ?";
			queryContent = "%"+queryContent+"%";
		}
		sql = sql+likeCondtition+" limit ?,?";

		if(currentPage>0){
			currentPage=currentPage-1;
		}
		if(currentPage<0){
			currentPage=0;
		}

		try {
			return DaoUtils.findAll(sql,Trademark.class,queryContent,currentPage,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

    /**
     * By HALOBING at 2014/5/8 18:00
     * 后台模糊查询商标名称
     * @return
     */
    public List<Trademark> adminLikeSearch(String name){
        String sql="SELECT * FROM t_trademark where trademarkName like ?";
        try {
            return DaoUtils.searchAll(sql,Trademark.class,"%"+name+"%");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

