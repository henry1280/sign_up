package com.baidu.service;

import com.baidu.dao.ZhangWuDao;
import com.baidu.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {

    private ZhangWuDao dao=new ZhangWuDao();
    /**
     * 定义方法,实现查询所有的账务数据
     *  此方法,由控制层调用, 去调用dao层的方法
     *  返回存储ZhangWu对象的List集合
     */
    public List<ZhangWu> selectAll(){
        return dao.selectAll();
    }
    public List<ZhangWu>select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }
    /**
     * 定义一个方法，实现修改账务数据
     * 方法：由控制层调用，去调用dao层方法
     */
    public void updateZhangWu(ZhangWu zw){
        dao.updateZhangWu(zw);
    }

    /**
     *定义一个方法，实现删除账务数据
     * 方法：由控制层，去调用dao层
     * @param zwid
     */
    public void deleteZhangWu(int zwid){
        dao.deleteZhangWu(zwid);
    }
    public void insertZhangWu(ZhangWu zw){
        dao.insertZhangWu(zw);
    }
}
