package com.my.scaffold.abstracts;

import java.util.ArrayList;
import java.util.List;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 9:45
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Test {

    public static void main(String[] args) {
        B a = new B();
        System.out.println(a.str);//A的非静态成员变量
        System.out.println(a.staticStr);//A的静态成员变量
        a.method();//B的成员方法
        a.staticMethod();//A的静态成员方法
        System.out.println("----------------------");
        B.staticMethod();
        System.out.println(a.getStaticStr());
        System.out.println(a.getStr());

        Inter.task();

    }
}
