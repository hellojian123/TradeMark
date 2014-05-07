package com.isoft.service;

import com.isoft.bean.Trademark;
import com.isoft.dao.TrademarkDao;

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

    /**
     * 获取商标总记录数
     * @return
     */
    public int getTotalCount(){
        return trademarkDao.getTotalCount();
    }
}
