package com.my.scaffold.class_load;

import com.my.scaffold.core.Father;
import com.my.scaffold.core.SonA;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/15 16:22
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class SonClass extends FatherClass {

    public static String  fatherClassName = "子类中静态变量";

    public String str = "子类中普通变量";

    static {
        System.out.println("子类的静态初始化代码块");
    }
    {
        System.out.println("子类的初始化代码块");
    }

    SonClass(){
        System.out.println("子类构造函数");
    }
    public static void staticMethod(){
        System.out.println("子类中静态方法");
    }

    public void method(){
        System.out.println("子类中普通方法");
    }

    /***********************************************************************
     * 1. 总结代码加载顺序：
     *   a. 静态 > 普通；
     *   b. 父类 > 子类；
     *   c. 变量 > 初始化代码块  >  构造函数
     *
     *
     *
     **************************************************************************/
    public static void main(String[] args) {
        SonClass sonClass = new SonClass();
        System.out.println("+++++++++++++++++++++");
    }
}
