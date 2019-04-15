package com.my.scaffold.pattern.producer_pattern;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    : 产品
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 15:54
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Phone {

    private int i;

    Phone(int i){
        this.i = i;
    }
    @Override
    public String toString(){
        return "手机编号："+i;
    }
}
