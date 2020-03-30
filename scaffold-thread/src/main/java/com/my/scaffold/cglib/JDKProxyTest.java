package com.my.scaffold.cglib;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2020/2/25 17:08
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        // 目标对象
        CgDao target = new CgDao();
        ProxyFactoryJDK proxyFactoryJDK = new ProxyFactoryJDK(target);

        CgDaoAbstract proxyCgDao = (CgDaoAbstract)proxyFactoryJDK.createProxy();
        proxyCgDao.save();
        proxyCgDao.say();
    }
}
