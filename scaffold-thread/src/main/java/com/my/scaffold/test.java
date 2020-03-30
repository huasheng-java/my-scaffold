package com.my.scaffold;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/30 15:34
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    : 有一序列  1、1、2、3、5、8、13、21、34、55、89、144、233 ……
 写一方法fun(n)，第n项的值
 * **************************************************************
 */
public class test {

    public static int _i=0 ;

    static {
        _i = 1;
        System.out.println("我是静态代码块");
    }
    test(){

    }
    test(int i){
        _i = i;
    }
    public static void main(String[] args){
        System.out.println(_i);
        test t1 = new test(2);
        test t2 = new test();
        System.out.println(_i);
        System.out.println(t2._i);
    }




}
