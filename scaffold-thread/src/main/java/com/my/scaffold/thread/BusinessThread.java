package com.my.scaffold.thread;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/31 16:10
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Component
// spring 多例
@Scope("prototype")
public class BusinessThread implements Runnable{

    private String acceptStr;

    public BusinessThread(String acceptStr){
        this.acceptStr = acceptStr;
    }
    public String getAcceptStr() {
        return acceptStr;
    }

    public void setAcceptStr(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    @Override
    public void run() {
        //业务操作
//        System.out.println("多线程已经处理订单插入系统，订单号："+acceptStr);
        //线程阻塞
        try {
            Thread.sleep(1000);
            System.out.println("多线程已经处理订单插入系统，订单号："+acceptStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
