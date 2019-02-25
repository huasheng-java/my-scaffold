package com.my.scaffold.pattern.simple_factory;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 简单工厂测试
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/20 14:39
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class SimpleFactoryTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 实例化食物
        Food mcChicken = FoodFactory.getFood("mcchicken");
        Food chips = FoodFactory.getFood("chips");
        Food egg = FoodFactory.getFood("egg");

        if (mcChicken != null){
            mcChicken.get();
        }
        if (chips != null){
            chips.get();
        }
        if (egg != null){
            egg.get();
        }
    }
}
