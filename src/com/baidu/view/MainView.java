package com.baidu.view;

import com.baidu.controller.ZhangWuController;
import com.baidu.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

public class MainView {

    private ZhangWuController controller=new ZhangWuController();
    //开始创建界面
    public void run(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("**************欢迎来到管家婆操作系统*******************");
            System.out.println("1，添加账务  2，编辑账务  3，删除账务  4，查询账务  5，退出系统");
            System.out.println("*******************************************************");
            System.out.println("请选择操作的功能：【1-5】");
            int choose = sc.nextInt();
            switch(choose){
                case 1:
                    //1，添加账务，调用添加的方法
                    insertZhangWu();
                    continue;
                case 2:
                    //2，编辑账务，调用修改的方法
                    updateZhangWu();
                    continue;
                case 3:
                    //3，删除账务，调用删除的方法
                    deleteZhangWu();
                    continue;
                case 4:
                    //4，查询账务，调用查询的方法
                    selectZhangWu();
                    continue;
                case 5:
                    //5，退出系统
                    break;
                default:
                    System.out.println("您输入的数字有误，请重新输入！！");
                    continue;
            }
            break;
        }
    }
    /**
     * 定义方法 selectZhangWu()
     * 显示查询的方式 1 所有查询   2 条件查询
     * 接收用户的选择
     */
    public void selectZhangWu(){
        System.out.println("1,查询所有  2，条件查询");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch(choose){
            case 1:
                //查询所有的方法
                selectAll();
                break;
            case 2:
                //条件查询的方法
                select();
                break;
        }
    }
    /**
     * 查询所有的方法
     */
    public void selectAll(){
        //调用控制层中的方法,查询所有的账务数据
        List<ZhangWu> zhangWus = controller.selectAll();
        System.out.println("ID+\t\t+分类+\t\t+金额+\t\t+账户+\t\t+时间+\t\t+说明");
        for(ZhangWu zw:zhangWus){
            System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getMoney()+"\t\t"+zw.getZhanghu()+"\t\t"+zw.getCreatetime()
                    +"\t\t"+zw.getDescription());
        }
    }
    /**
     * 条件查询的方法
     * 定义方法,实现条件查询账务数据
     * 提供用户的输入日期,开始日期结束日期
     * 就2个日期,传递到controller层
     * 调用controller的方法,传递2个日期参数
     * 获取到controller查询的结果集,打印出来
     */
    public void select(){
        System.out.println("您已选择条件查询，输入的格式为：yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始日期：");
        String startDate = sc.next();
        System.out.println("请输入结束日期：");
        String endDate = sc.next();
        List<ZhangWu> list = controller.select(startDate, endDate);
        if(list.size()!=0){
            for(ZhangWu zw:list){
                System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getMoney()+"\t\t"+zw.getZhanghu()+"\t\t"+zw.getCreatetime()
                        +"\t\t"+zw.getDescription());
            }
        }else{
            System.out.println("查询失败！");
        }
    }
    public void print(List<ZhangWu> list){
        System.out.println("ID+\t\t+分类+\t\t+金额+\t\t+账户+\t\t+时间+\t\t+说明");
        for(ZhangWu zw:list){
            System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getMoney()+"\t\t"+zw.getZhanghu()+"\t\t"+zw.getCreatetime()
                    +"\t\t"+zw.getDescription());
        }
    }
    /**
     * 调用查询所有账务数据的功能，显示出来
     看到所有数据，从中选择一项，进行修改
     */
    public void updateZhangWu(){
        selectAll();
        System.out.println("您已选择编辑账务功能，请输入数据：");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入ID");
        int zwid = sc.nextInt();
        System.out.println("请输入分类名称");
        String flname = sc.next();
        System.out.println("请输入金额");
        Double money = sc.nextDouble();
        System.out.println("请输入账户");
        String zhanghu = sc.next();
        System.out.println("请输入时间（格式是yyyy-MM-dd）");
        String createtime = sc.next();
        System.out.println("请输入账务描述");
        String description= sc.next();
        ////将用户输入的数据，封装到ZhangWu对象中
        //用户输入的ID，必须封装到到对象中
        ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu,createtime, description);
        controller.updateZhangWu(zw);
        System.out.println("编辑账务成功！！");
    }
    /**
     * 首先调用查询所有的方法，然后看到一条数据进行删除
     */
    public void deleteZhangWu(){
        selectAll();
        System.out.println("您已选择删除账务动能，请输入数据：");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id");
        int zwid = sc.nextInt();
        controller.deleteZhangWu(zwid);
        System.out.println("账务删除成功！！");
    }
    /**
     * 添加数据，首先我们要先看看添加在哪里，查询所有的数据
     * 然后插入
     */
    public void insertZhangWu(){
        selectAll();
        System.out.println("您已选择添加账务功能，请输入数据：");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id");
        int zwid = sc.nextInt();
        System.out.println("请输入分类");
        String flname = sc.next();
        System.out.println("请输入金额");
        double money = sc.nextDouble();
        System.out.println("请输入账户");
        String zhanghu = sc.next();
        System.out.println("请输入时间（格式：yyyy-MM-dd）");
        String createtime = sc.next();
        System.out.println("请输入账务描述");
        String description = sc.next();
        ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
        controller.insertZhangWu(zw);
        System.out.println("添加账务成功！！");
    }
}
