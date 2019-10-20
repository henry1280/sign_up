package com.baidu.controller;

import com.baidu.domain.ZhangWu;
import com.baidu.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {

    private ZhangWuService service=new ZhangWuService();
    /**
     * 控制层类定义方法,实现查询所有的账务数据
     * 方法由试图层调用,方法调用service层
     */
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }
    public List<ZhangWu> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }
    public void updateZhangWu(ZhangWu zw){
        service.updateZhangWu(zw);
    }
    public void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }
    public void insertZhangWu(ZhangWu zw){
        service.insertZhangWu(zw);
    }
}
