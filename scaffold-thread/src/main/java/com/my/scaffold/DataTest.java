package com.my.scaffold;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/31 9:42
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class DataTest {
    private static String a = "1";
    private static DataTest t = new DataTest();
    static {
        System.out.println(DataTest.a);
        DataTest.a = "2";
        System.out.println(DataTest.a);
        System.out.println(DataTest.b);
        DataTest.b = "4";
        System.out.println(DataTest.b);
    }
    {
        System.out.println("我是构造代码块");
    }
    private static String b = "3";

    public DataTest() {
        System.out.println("构造函数");
        System.out.println(DataTest.a);
        System.out.println(DataTest.b);
    }

    public static void start(){ }

    public static void main(String[] args) {
        DataTest.start();
    }
}
