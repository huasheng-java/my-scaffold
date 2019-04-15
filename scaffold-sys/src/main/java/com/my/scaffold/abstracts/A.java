package com.my.scaffold.abstracts;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 9:43
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public abstract class A {

    public static String staticStr = "A静态成员变量";

    public String str = "A非静态成员变量";

    public static void staticMethod() {
        System.out.println("A静态方法");
    }
    public void method(){
        System.out.println("A非静态方法");
    }

    public static String getStaticStr() {
        return staticStr;
    }

    public static void setStaticStr(String staticStr) {
        A.staticStr = staticStr;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
