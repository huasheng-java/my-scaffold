package com.my.scaffold.abstracts;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/11 18:54
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Son extends Person {
    public String a;
    Son(String a) {
        super("Person");
        this.a =a;
    }

    @Override
    public String getA() {
        return a;
    }

    @Override
    public void setA(String a) {
        this.a = a;
    }
    public void say1(){
        System.out.println(super.a);
    }
}
