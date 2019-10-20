package com.baidu.dao;

import com.baidu.domain.ZhangWu;
import com.baidu.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {

    private QueryRunner qr=new QueryRunner(JDBCUtils.getdataSource());
    /**
     * 定义方法,查询数据库,获取所有的账务数据
     * 方法,由业务层调用
     * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
     */
    public List<ZhangWu> selectAll(){
        String  sql="select * from zhangwu";
        try {
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("查询所有账务失败");
        }
    }
    /**
     * 定义方法,查询数据库,带有条件去查询账务表
     * 由业务层调用,查询结果集存储到Bean对象,存储到List集合
     * 调用者传递2个日期字符串
     */
    public List<ZhangWu> select(String startDate,String endDate){
        try {
            String sql="select * from zhangwu where createtime between ? and ?";
            Object[] parms={startDate,endDate};
            return qr.query(sql, new BeanListHandler<>(ZhangWu.class), parms);
        } catch (SQLException e) {
            throw new RuntimeException("查询条件账务失败"+e);
        }

    }
    /**
     * 定义一个方法：修改数据库
     * 方法，由业务层调用
     */
    public void updateZhangWu(ZhangWu zw){
        try {
            String sql="update zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
            Object[]prams={zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
            qr.update(sql, prams);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("修改账务失败");
        }
    }
    /**
     * 定义一个方法，删除数据库
     * 方法，由业务层调用
     */
    public void deleteZhangWu(int zwid){
        String sql="delete from zhangwu where zwid=?";
        try {
            qr.update(sql,zwid);
        } catch (SQLException e) {
            throw new RuntimeException("删除失败"+e);
        }
    }
    /**
     * 增加数据，然后由业务层调用
     */
    public void insertZhangWu(ZhangWu zw){
        try {
            String sql="insert into zhangwu(zwid,flname,money,zhanghu,createtime,description) values(?,?,?,?,?,?)";
            Object[] prams={zw.getZwid(),zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
            qr.update(sql,prams);
        } catch (SQLException e) {
            throw new RuntimeException("添加账务失败"+e);
        }
    }
}
