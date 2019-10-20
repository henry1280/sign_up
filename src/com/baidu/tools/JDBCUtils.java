package com.baidu.tools;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

    //2.创建一个ComboPooledDataSource对象
    public static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //3.在静态代码块中使用ComboPooledDataSource对象，的setxxx方法来设置数据库连接
    static {
        try {
            //注册驱动
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            //设置URL
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/tt_0921?serverTimezone=UTC");
            //设置用户名
            dataSource.setUser("root");
            //设置密码
            dataSource.setPassword("admin");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    //定义一个静态方法，通过ComboPooledDataSource的对象，来获得数据库连接Connection对象
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            //避免异常时，程序继续运行
            throw new RuntimeException("数据库连接失败" + e);
        }
    }

    //定义一个方法可以返回连接池
    public static ComboPooledDataSource getdataSource(){
        return dataSource;
    }

    //定义一个方法用来释放资源
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
