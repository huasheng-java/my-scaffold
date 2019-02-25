package com.my.scaffold.proxy;

import com.my.scaffold.proxy.impl.UserDao;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/13 12:38
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class App {

    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();
        System.out.println("原始类型："+target.getClass());

        //给目标对象 创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("代理类型："+proxy.getClass());

        //执行方法
        proxy.save();
    }
}
