package com.my.scaffold.quartz;

import org.apache.commons.lang.time.DateUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/7/12 13:51
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class MyJobScheduler {

    public static void main(String[] args) throws SchedulerException {
        // 创建一个 JobDetail 实例。将该实例与 job 实例绑定
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myjob","group1")
                .build();

        System.out.println("jobDetail·name: " + jobDetail.getKey().getName());
        System.out.println("jobDetail·group："+jobDetail.getKey().getGroup());
        System.out.println("jobDetail·jobClass:" + jobDetail.getJobClass().getName());


        // 创建一个 Trigger(触发器) 实例，定义该job立即执行，并每隔两秒重复一次，直到永久
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","trigroup") // 定义触发器标识符
                .startNow()  // 定义立即执行
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()) // 定义执行频率
                .endAt(DateUtils.addSeconds(new Date(),10))
                .build();

        // 创建一个 Scheduler(调度器) 实例，
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 绑定 JobDetail 和 Trigger
        scheduler.scheduleJob(jobDetail,trigger);

        // 执行调度器
        scheduler.start();

    }
}
