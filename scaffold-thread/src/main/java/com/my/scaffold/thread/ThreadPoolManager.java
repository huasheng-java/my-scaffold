package com.my.scaffold.thread;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 线程池管理类
 * 业务描述    :  https://blog.csdn.net/u011677147/article/details/80271174
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/30 15:50
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Component
public class ThreadPoolManager implements BeanFactoryAware{

    /**
     * 用于从IOC中获取对象
     * 如果实现Runnable的类是通过spring的application.xml文件进行注入,可通过 factory.getBean()获取，这里只是提一下
     */
    private BeanFactory beanFactory;

    /**
     * 线程池维护线程的核心线程数量
     */
    private final static int CORE_POOL_SIZE = 2;
    /**
     * 线程池维护线程的最大数量
     */
    private final static int MAX_POOL_SIZE = 10;
    /**
     * 线程池维护线程所允许的空闲时间（超出核心线程数量以外的线程空余存活时间）
     */
    private final static int KEEP_ALIVE_TIME = 0;
    /**
     * 线程池所使用的缓冲队列大小
     */
    private final static int WORK_QUEUE_SIZE = 50;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 用于储存在队列中的订单，防止重复提交，在真实场景中，可用redis代替 验证重复
     */
    Map<String,Object> cacheMap = new ConcurrentHashMap<>();

    /**
     * 订单的缓冲队列，当线程池满了，则将订单存入到此缓冲队列
     */
    Queue<Object> msgQueue = new LinkedBlockingQueue<Object>();

    /**
     * 当任务无法执行时的处理器
     * : 既线程池的容量满了，执行该处理器，将订单存入到缓冲队列
     */
    final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 订单加入到缓冲队列
            msgQueue.offer(((BusinessThread)r).getAcceptStr());
            System.out.println("系统任务太忙了，把此订单交给（调度线程池）逐一处理，订单号："+((BusinessThread)r).getAcceptStr());
            System.out.println("缓冲队列中待处理订单数："+msgQueue.size());
        }
    };

    /**
     * 线程池
     * 1. 核心线程的数量
     * 2. 最大线程数量
     * 3. 超出核心线程数量以外的线程空余存活时间
     * 4. 存活时间的单位
     * 5. 保存待执行任务的队列
     * 6. 当任务无法执行时的处理器
     */
    final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue(WORK_QUEUE_SIZE),
            this.handler);

    /**
     * 将任务加入订单线程池
     * @param orderId
     */
    public void addOrders(String orderId){
        System.out.println("此订单准备添加到线程池，订单号："+orderId);
        /**
         * 验证当前进入的订单是否已存在
         */
        if (cacheMap.get(orderId) == null){
            cacheMap.put(orderId,new Object());
        }
        BusinessThread businessThread = new BusinessThread(orderId);
        threadPool.execute(businessThread);
    }

    /**
     * 线程池的定时任务：称为（调度线程池）。此线程池支持  定时以及周期性执行任务的需求。
     * http://ifeve.com/33981-2/
     */
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    final ScheduledFuture scheduledFuture = scheduler.scheduleAtFixedRate(
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("调度线程池执行中.......");
                    //判断缓冲队列是否存在记录
                    if (!msgQueue.isEmpty()){
                        System.out.println("（调度线程池）检查缓冲队列中待处理订单数："+msgQueue.size());
                        System.out.println("线程池的队列容量："+ threadPool.getQueue().size());
                        //当线程池的队列容量少于WORK_QUEUE_SIZE，则开始把缓冲队列的订单 加入到线程池
                        if (threadPool.getQueue().size() < WORK_QUEUE_SIZE ){
                            String orderId = (String) msgQueue.poll();
                            BusinessThread businessThread = new BusinessThread(orderId);
                            threadPool.execute(businessThread);
                            System.out.println("（调度线程池）缓冲队列出现订单业务，重新添加到线程池，订单号："+orderId);
                        }
                    }
                }
            }
    ,0,1,TimeUnit.SECONDS);

    /**
     * 获取消息缓冲队列
     * @return
     */
    public Queue<Object> getMsgQueue(){
        return msgQueue;
    }

    /**
     * 终止订单线程池+调度线程池
     */
    public void shutdown(){
        //true标识如果定时任务在执行，立即终止。false则等待任务结束后再停止
        System.out.println("终止订单线程池+调度线程池："+scheduledFuture.cancel(false));
        scheduler.shutdown();
        threadPool.shutdown();
    }

}
