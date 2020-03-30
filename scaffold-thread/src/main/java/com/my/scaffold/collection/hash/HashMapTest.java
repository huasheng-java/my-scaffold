package com.my.scaffold.collection.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/19 15:52
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Person,Dog> map = new HashMap<>();

        Person person = new Person();
        person.setId(1);
        person.setName("人员1号");

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("人员2号");

        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("狗狗1");

        Dog dog1 = new Dog();
        dog1.setId(2);
        dog1.setName("狗狗2号");

        // 体现hash碰撞：key的hashCode()方法返回值一致，需存放在hashMap 底层数组同一位置处。
        // 再根据equals（）判断该位置上的链表中是否有相同的，若无则存放在链表头部。
        map.put(person,dog);
        map.put(person1,dog1);
        System.out.println(map.size());

    }
}
