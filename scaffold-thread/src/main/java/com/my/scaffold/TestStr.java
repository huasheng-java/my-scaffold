package com.my.scaffold;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/15 14:58
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class TestStr {
    public void fun(String str) {
        str = " 张柏芝 ";
    }
    public static void main(String args[]) {
        TestStr t = new TestStr();
        String str = " 郭美美 ";
        t.fun(str);
        System.out.println(str);
    }
}
