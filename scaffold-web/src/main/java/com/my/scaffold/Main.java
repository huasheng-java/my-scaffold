package com.my.scaffold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2020/4/9 17:36
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class Main {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();




    }

    /**
     * 四则远算：
     * 先括号，后乘除，再加减
     * @param strExpression
     * @return
     */
    public static int calculate(String strExpression){
        List<String> list = new ArrayList<>();
        //用于标识上一个加入list中的是否是数子
        boolean flag = false;
        for (int i=0;i<strExpression.length();i++){
            char c = strExpression.charAt(i);
            if (0<= c && c<=9){
                //数字
                if (!flag){
                    list.add(String.valueOf(c));
                }else{
                    String last = list.get(list.size() - 1);
                    list.add(list.size() - 1,last+c);
                }
            }else if (c == '*' || c == '/' || c == '+'){
                list.add(String.valueOf(c));
            }else if (c == '-'){
                char last = strExpression.charAt(i-1);
                if (last == ')' ||
                        (0<= last && last<=9)){

                }
            }
            list.add(strExpression.charAt(i)+"");
        }
        return 0;
    }
}
