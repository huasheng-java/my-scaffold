package com.my.scaffold.core;

import java.math.BigDecimal;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/26 15:46
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Test {

    public static void change(String a,String b){
        a = b;
        b = b+a;
    }

    public static void change(StringBuffer a,StringBuffer b){
        a = b;
        b.append(a);
    }
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        change(a,b);
        System.out.println(a +"  "+b);

        StringBuffer c = new StringBuffer("hello");
        StringBuffer d = new StringBuffer("world");
        change(c,d);
        System.out.println(c +"  "+ d);

    }
}
