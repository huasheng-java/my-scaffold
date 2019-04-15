package com.my.scaffold.core;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/26 15:39
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class SonA extends Father {

    public static String staticString = "子类中的静态变量";

    public String str = "子类中的非静态变量";

    public static void staticMethod(){
        System.out.println("子类中静态方法");
    }

    public void method(){
        System.out.println("子类中的非静态方法");
    }

    public static void main(String[] args) {
        SonA sonA = new SonA();
        System.out.println(sonA.str);
//        System.out.println(sonA.staticString);
//        sonA.staticMethod();
//        sonA.method();
        System.out.println("=============================================");
        Father father = new SonA();
        System.out.println(father.str);
        System.out.println(Father.staticString);
        Father.staticMethod();
        father.method();
        System.out.println("==============================================");

    }
}
