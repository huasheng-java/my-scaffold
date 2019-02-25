package com.my.scaffold.collection;

import java.util.*;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/2/19 14:05
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class CollectionSteady {

    public static void main(String[] args) {
        //有序可重复
        // 底层数组，线程不安全。查询快，增删慢
        List<String> list1 = new ArrayList<>();
        //底层数据，线程安全。查询快，增删慢
        List<String> list2 = new Vector<>();
        //底层链表，线程不安全。查询满，增删快
        List<String> list3 = new LinkedList<>();


        // 无序不可重复、可存放null；线程不安全
        // 底层数组(哈希表)
        Set<String> set = new HashSet<>();

        //有序不可重复; 线程不安全
        //底层链表+哈希表：链表保证有序，哈希表保证唯一性
        Set<String> set1 = new LinkedHashSet<>();
        set1.add(null);

        //有序不可重复 ，不可存放null; 线程不安全
        //底层红黑树算法，范围查找
        Set<String> set2 = new TreeSet<>();

        //生成线程安全的set
        Set set3 = Collections.synchronizedSet(set);

        HashMap<String,String> hashMap = new HashMap<>();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i=0;i<10;i++){
                        hashMap.put(i+"",i+"");
                    }
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(hashMap.size());
    }
}
