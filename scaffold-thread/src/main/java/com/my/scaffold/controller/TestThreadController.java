package com.my.scaffold.controller;

import com.my.scaffold.thread.ThreadPoolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;
import java.util.UUID;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/15 14:45
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Controller
@RequestMapping("thread")
public class TestThreadController {

    @Autowired
    private ThreadPoolManager threadPoolManager;

    /**
     * 测试模拟下单请求 入口
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    @ResponseBody
    public String start(@PathVariable Long id){
        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();
        threadPoolManager.addOrders(orderNo);
        return "Test ThreadPoolExecutor start";
    }

    /**
     * 停止服务
     * @param id
     * @return
     */
    @GetMapping("/end/{id}")
    @ResponseBody
    public String end(@PathVariable Long id){
        threadPoolManager.shutdown();
        Queue queue = threadPoolManager.getMsgQueue();
        System.out.println("关闭了线程服务，还有未处理的信息条数："+ queue.size());
        return "Test ThreadPoolExecutor end";
    }













}
