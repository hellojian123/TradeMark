package com.isoft.service;

import com.isoft.bean.Trademark;
import com.isoft.dao.TradeSearchDao;

/**
 * Created by Administrator on 14-5-7.
 */
public class FindTradeDetailService  {
    private TradeSearchDao tradeSearchDao= new TradeSearchDao();

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
