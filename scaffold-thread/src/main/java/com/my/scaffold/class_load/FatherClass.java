package com.my.scaffold.class_load;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 父类
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/15 16:19
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class FatherClass {

    public static String  fatherClassName = "父类中静态变量";

    static {
        System.out.println("父类的静态初始化代码块");
    }
    {
        System.out.println("父类的初始化代码块");
    }

    FatherClass(){
        System.out.println("父类构造函数");
    }
    public static void staticMethod(){
        System.out.println("父类中静态方法");
    }

    public void method(){
        System.out.println("父类中普通方法");
    }
}
