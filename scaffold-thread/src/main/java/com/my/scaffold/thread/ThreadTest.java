package com.my.scaffold.thread;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/18 12:37
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class ThreadTest implements Runnable {

     static  Object o = new Object();

    private VolatileNumModel numModel;

    private String name;

    /**
     * 需要同步的变量加上volatile
     */
    private volatile int anInt = 0;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    ThreadTest(String name){
        this.name = name;
    }

    ThreadTest(VolatileNumModel numModel){
        this.numModel = numModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void demo(){
        System.out.println("开始执行同步块........"+getName());
        synchronized (o){
            System.out.println("同步块内部执行中......"+getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("同步块执行结束........"+getName());
    }


    /**
     * 这里不再需要synchronized
     * @param myint
     */
    public void save(int myint){
        for (int i =0 ; i<100;i++){
            anInt = getAnInt() +  myint;
        }
    }


    public void run() {
        numModel.setAnInt(10);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前值："+getAnInt());
    }

//    @Override
//    public void run() {
//        demo();
//    }
}
