package com.my.scaffold.pattern.producer_pattern;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 生产者
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 15:56
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Producer implements Runnable {

    private PublicBox<Phone> publicBox;

    Producer(PublicBox<Phone> publicBox){
        this.publicBox = publicBox;
    }

    @Override
    public void run() {
        for (int i =0;i<20;i++){
//            publicBox.produce(new Phone(i));

            publicBox.producerQueue(new Phone(i));
            try {
                //每隔十毫秒生产一个
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
