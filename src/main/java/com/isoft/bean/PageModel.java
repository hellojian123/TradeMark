package com.isoft.bean;

import java.util.List;
/**
 * 分页模型
 * @author Administrator
 *
 * @param <T>
 */
public class PageModel<T> {

    /**每页显示的条数**/
    private int pageSize;
    /**查询到的list结果集**/
    private List<T> result;
    /**查询到的总记录数**/
    private int count;
    /**最大分页数**/
    private int maxPage;

    public PageModel(){}

    public PageModel(int totalCount,int pageSize,List<T> result) {
        this.count=totalCount;
        this.pageSize=pageSize;
        this.result=result;
    }
    public PageModel(int totalCount,int pageSize) {
        this.count=totalCount;
        this.pageSize=pageSize;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    /**
     * 设置最大分页数，根据总记录数和每页显示的条数计算而得
     * @return
     */
    public int getMaxPage() {
        if(pageSize>0){
            if((count%pageSize)!=0){
                return(count/pageSize)+1;
            }else{
                return count/pageSize;
            }
        }
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

}