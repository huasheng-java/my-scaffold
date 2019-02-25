package com.my.scaffold.thread;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/18 12:34
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class TestThread {

    public static void main(String[] args) {
        VolatileNumModel model = new VolatileNumModel(1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始赋值");
                int i = 10;
                model.setAnInt(i);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("赋值+睡眠结束");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("开启线程2：");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("获得值："+model.getAnInt());
            }
        });
        thread.start();
        thread1.start();
    }
}
