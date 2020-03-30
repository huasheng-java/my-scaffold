package com.my.scaffold;

import java.util.Collection;
import java.util.HashMap;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/6/26 17:52
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Father {

    public long a = 0;

    Collection doSomeThing(HashMap map){
        System.out.println("父类执行");
        return map.values();
    }

    public long getA() {
        return a;
    }

    public void setA(long a) {
        this.a = a;
    }

    private void privateMethod(){
        System.out.println("父类的私有方法");
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("key","value");
        map.put("key","value2");
        System.out.println(map.get("key"));
    }
}
