package com.my.scaffold.cglib;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/13 13:34
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class CgDao implements CgDaoAbstract{

    public void save(){
        System.out.println("CGlib 已经保存");
    }

    @Override
    public void say() {
        System.out.println("JDK已经保存");
    }
}
