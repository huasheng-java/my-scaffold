package com.my.scaffold.pattern.singleton;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/20 17:53
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class ThreadSingletonTest extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton.geInstance().hashCode());
    }

    public static void main(String[] args) {
        ThreadSingletonTest[] mts = new ThreadSingletonTest[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new ThreadSingletonTest();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
