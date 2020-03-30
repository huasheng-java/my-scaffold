package com.my.scaffold;

import org.apache.poi.ss.formula.functions.T;

import java.util.HashMap;

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
        String a= "123";
        String b="123";
        System.out.println(a == b);
        Test t1 = new Test();
        t1.setName("woshi1");
        System.out.println(t1.getName());
        Test t2 = new Test();
        t2.setName("woshi2");
        change(t1,t2);
        System.out.println(t1.getName());
    }

    public static void change(Test t1,Test t2){
        t1 = t2;
    }

    static class Test{
        private String name;

        public Test(){
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
