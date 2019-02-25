package com.my.scaffold.pattern.singleton;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 单例模式
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/20 17:45
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){

    }
    public static Singleton geInstance(){
        if (singleton == null){
            try {
                //创建实例之前可能会有一些准备性的耗时工作,以便看出多线程下并发执行异常
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(Singleton.class){
                if (singleton == null){  // 第二次检查
                    singleton = new Singleton();
                }

            }

        }
        return singleton;
    }
}
