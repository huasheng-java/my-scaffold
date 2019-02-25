package com.my.scaffold.annotation;

import com.my.scaffold.enums.OperationType;

import java.lang.annotation.*;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 服务类日志自定义注解
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/28 16:41
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Documented
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLog {

    String value() default "";

    int  level() default 0;

    OperationType operationType() default OperationType.UNKNOWN;




}
