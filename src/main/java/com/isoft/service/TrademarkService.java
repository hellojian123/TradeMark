package com.isoft.service;

import com.isoft.bean.Trademark;
import com.isoft.dao.TrademarkDao;
import com.isoft.util.DaoUtils;

import java.util.List;

/**
 * Created by Administrator on 14-5-4.
 */
public class TrademarkService {

    private TrademarkDao trademarkDao= new TrademarkDao();

    /**
     * 保存或修改
     * @param trademark
     * @return
     */
    public boolean saveOrUpdate(Trademark trademark){
        if(trademark.getId()==-1){//保存
            trademarkDao.save(trademark);

        }else{
            trademarkDao.update(trademark);
        }
        return true;
    }

    /**
     * 根据id获取一条商标
     * @param id
     * @return
     */
    public Trademark getById(int id){
        if (id==0){
            return null;
        }
        return trademarkDao.getById(id);
    }

    /**
     * 分页查询
     * @param pageSize
     * @param currentPage
     * @return
     */
    public List<Trademark> pagingBySql(int pageSize,int currentPage){
        return trademarkDao.pagingBySql(pageSize,currentPage);
    }

    public List<Trademark> pagingTNameBySql(int pageSize,int currentPage,String trademarkName){
        return trademarkDao.pagingTNameBySql(pageSize, currentPage, trademarkName);
    }
    public List<Trademark> pagingLikeTNameBySql(int pageSize,int currentPage,String trademarkName){
        return trademarkDao.pagingLikeTNameBySql(pageSize, currentPage, trademarkName);
    }

    public List<Trademark> pagingCHNameBySql(int pageSize,int currentPage,String applicantNameZh){
        return trademarkDao.pagingCHNameBySql(pageSize, currentPage, applicantNameZh);
    }
    public List<Trademark> pagingLikeCHNameBySql(int pageSize,int currentPage,String applicantNameZh){
        return trademarkDao.pagingLikeCHNameBySql(pageSize, currentPage, applicantNameZh);
    }

    public List<Trademark> pagingENNameBySql(int pageSize,int currentPage,String applicantNameEn){
        return trademarkDao.pagingENNameBySql(pageSize, currentPage, applicantNameEn);
    }
    public List<Trademark> pagingLikeENNameBySql(int pageSize,int currentPage,String applicantNameEn){
        return trademarkDao.pagingLikeENNameBySql(pageSize, currentPage, applicantNameEn);
    }
    /**
     * 获取商标总记录数
     * @return
     */
    public int getTotalCount(){
        return trademarkDao.getTotalCount();
    }
    /**
     * 根据商标注册号查询
     */
    public  Trademark findByApplyNum(String applyNum){
        if (applyNum==null){
            return null;
        }
        return trademarkDao.findByApplyNum(applyNum);
    }
    /**
     * 根据商标名精确查询
     */
    public List<Trademark> findByTrademarkName(String trademarkName){
        if (trademarkName==null){
            return null;
        }
        return trademarkDao.findByTrademarkName(trademarkName);
    }
    /**
     * 根据商标名模糊查询
     */
    public List<Trademark> findByLikeTrademarkName(String trademarkName){
        if (trademarkName==null){
            return null;
        }
        return trademarkDao.findByTrademarkLikeName(trademarkName);
    }
    /**
     * 根据中文名精确查询
     */
    public List<Trademark> findByCHPName(String applicantNameZh){
        if (applicantNameZh==null){
            return null;
        }
        return trademarkDao.findByApplicantNameZh(applicantNameZh);
    }
    /**
     * 根据中文名模糊查询
     */
    public List<Trademark> findByLikeCHPName(String applicantNameZh){
        if (applicantNameZh==null){
            return null;
        }
        return trademarkDao.findByLikeApplicantNameZh(applicantNameZh);
    }
    /**
     * 根据en名精确查询
     */
    public List<Trademark> findByENGPName(String applicantNameEn){
        if (applicantNameEn==null){
            return null;
        }
        return trademarkDao.findByApplicantNameEn(applicantNameEn);
    }
    /**
     * 根据en名模糊查询
     */
    public List<Trademark> findByLikeENGPName(String applicantNameEn){
        if (applicantNameEn==null){
            return null;
        }
        return trademarkDao.findByLikeApplicantNameEn(applicantNameEn);
    }
    /**
     * 按商标名称获取总数
     */
    public int getTotalByTradeName(String trademarkName){
        if (trademarkName==null){
            return -1;
        }
        return trademarkDao.getTotalByTrademarkName(trademarkName);
    }
    /**
     * 按like商标名称获取总数
     */
    public int getTotalByLikeTradeName(String trademarkName){
        if (trademarkName==null){
            return -1;
        }
        return trademarkDao.getTotalByLikeTrademarkName(trademarkName);
    }

    /**
     * 按中文名称获取总数
     */
    public int getTotalByCHPName(String applicantNameZh){
        if (applicantNameZh==null){
            return -1;
        }
        return trademarkDao.getTotalByCHPName(applicantNameZh);
    }
    /**
     * 按like中文名称获取总数
     */
    public int getTotalByLikeCHPName(String applicantNameZh){
        if (applicantNameZh==null){
            return -1;
        }
        return trademarkDao.getTotalByLikeCHPName(applicantNameZh);
    }

    /**
     * 按en名称获取总数
     */
    public int getTotalByENGPName(String applicantNameEn){
        if (applicantNameEn==null){
            return -1;
        }
        return trademarkDao.getTotalByENGPName(applicantNameEn);
    }
    /**
     * 按like en名称获取总数
     */
    public int getTotalByLikeENGPName(String applicantNameEn){
        if (applicantNameEn==null){
            return -1;
        }
        return trademarkDao.getTotalByLikeENGPName(applicantNameEn);
    }
}
