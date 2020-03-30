package com.my.scaffold;

import static sun.misc.Version.println;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/30 14:30
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class OverLoad {

    int height;

    OverLoad(){
        System.out.println("默认的无参构造");
        height = 0;
    }
    void info(){
        System.out.println("方法");
    }
    void info(String s){
        System.out.println("重载方法："+s);
    }

    public static void main(String[] args) {

    }




























}
