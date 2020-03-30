package com.my.scaffold;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/6/26 17:54
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Son extends Father {

    private long a =1 ;
    public Collection doSomeThing(HashMap map){
        System.out.println("子类类执行");
        return map.values();
    }

    public static void main(String[] args) {
        Father son = new Son();
        HashMap map = new HashMap();
        son.doSomeThing(map);
        System.out.println(son.a);;
    }
}
