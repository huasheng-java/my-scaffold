package com.my.scaffold.pattern.producer_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 公共缓存区
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/12 15:35
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class PublicBox<T> {

    //最大容量
    private int max;
    //1,存储集合
    private List<T> list = new ArrayList<>(max);

    //2. 使用阻塞队列
    private BlockingQueue<T> queue = new LinkedBlockingQueue(5);

    PublicBox(int max){
        this.max = max;
    }

    /**
     * 向缓存区存放
     */
    public synchronized void produce(T item){
        while(list.size() >= max){
            try {
                System.out.println("缓存区满了");
                this.wait();
                System.out.println("缓存有空间了，开始生产.............");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产："+item.toString());
        list.add(item);
        //唤醒消费者
        notifyAll();
    }

    /**
     * 从缓存区消费
     */
    public synchronized void consume(){
        while (list.size() == 0){
            try {
                System.out.println("缓存区空了");
                wait();
                System.out.println("缓存区有数据了，开始消费..............");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了："+list.remove(list.size() - 1));

        // 唤醒其他线程：生产者，消费者
        notifyAll();
    }


    /**
     * 生产：存放到阻塞队列中
     * @param item
     */
    public void producerQueue(T item){
        try {
            queue.put(item);
            System.out.println("生产者" + Thread.currentThread().getName()
              + "生产一件资源," + "当前资源池有" + queue.size() +"个资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费：取出存放在阻塞队列中的产品
     */
    public void consumeQueue(){
        try {
            queue.take();
            System.out.println("消费者"+Thread.currentThread().getName()
              +"消费了一件资源，当前资源池中有"+queue.size()+"个资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
