package com.my.scaffold.aspect;

import jdk.nashorn.internal.scripts.JO;
import net.sf.jsqlparser.statement.select.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :服务类日志 AOP切面类
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/29 14:28
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Aspect
@Component
public class ServiceLogAspect {

    /**
     * 切点方法
     */
    @Pointcut("@annotation(com.my.scaffold.annotation.ServiceLog)")
    public void serviceLog(){};

    @Before("serviceLog()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("切点方法之前执行");
    }

    @After("serviceLog()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("切点方法之后执行");
    }

    @AfterReturning("serviceLog()")
    public void doAfterReturn(JoinPoint joinPoint){
        System.out.println("切点方法返回之后执行");
    }

    @Around("serviceLog()")
    public void doAround(JoinPoint joinPoint){
        System.out.println("切点环绕型增强");
    }

    @AfterThrowing("serviceLog()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("切入内容返回异常后逻辑处理");
    }

}
