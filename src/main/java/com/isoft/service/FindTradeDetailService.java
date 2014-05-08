package com.isoft.service;

import com.isoft.bean.Trademark;
import com.isoft.dao.TrademarkDao;

/**
 * Created by Administrator on 14-5-7.
 */
public class FindTradeDetailService  {
    private TrademarkDao tradeSearchDao= new TrademarkDao();

    /**
     *    根据id查询出商标详细
     * @param id
     * @return
     */
    public Trademark findTrademarkDetailById(Integer id){
        if (id==null){
            return null;
        }
        return tradeSearchDao.findById(id);
    }
}
