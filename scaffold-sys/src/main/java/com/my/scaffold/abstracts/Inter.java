package com.my.scaffold.abstracts;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 9:15
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public interface Inter {

    String a ="str";

    public default void say(){
        System.out.println("我是接口的默认方法");
    }

    static void task(){
        System.out.println("我是接口的静态方法");
    }

}
