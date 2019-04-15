package com.my.scaffold.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/22 9:23
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public  class AlgorithmUtils {

    /**
     * 冒泡排序：
     * 1. 比较相邻元素，若第一个大于第二个，则交换他们两
     * 2. 对每一对相邻元素作同样的工作，从开始第一队到结尾最后一对。这步做完，最后的元素会是最大的
     * 3. 针对所有的元素重复以上步骤，除了最后一个
     * 4. 持续每次对越来越少的元素重复上面步骤，直到没有任何一对数字需要交换
     * @param source
     * @return
     */
    public static int[] bubbleSort(int[] source){
        // 复制数组
        int[] arr = Arrays.copyOf(source,source.length);
        for (int i = 1;i<source.length;i++){
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j =0; j<source.length-i;j++){
                if (arr[j] > arr[j+1]){
                    int num = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = num;
                    // 有过交换
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return arr;
    }

    /**
     * 选择排序：
     * 1. 先在未排序序列中找到最小(大)元素，存放在排序序列的起始位置
     * 2. 再从剩余未排序元素中继续寻找最小(大)元素，然后放到已排序序列的末尾。
     * 3. 重复第二步，知道所有元素排序完毕
     * @param source
     * @return
     */
    public static int[] selectionSort(int[] source){
        // 复制数组
        int[] arr = Arrays.copyOf(source,source.length);
        // 总共需要n-1轮比较
        for (int i =0; i<arr.length-1; i++){
            int max  = i;
            // 每轮需要n-1轮比较
            for (int j =i+1; j<arr.length; j++){
                if (arr[max] < arr[j]){
                    // 记录找到的最大值下标
                    max = j;
                }
            }
            // 将找到的最大值与i位置的值交换
            if (i != max){
                int num = arr[i];
                arr[i] = arr[max];
                arr[max] = num;
            }
        }
        return arr;
    }

    /**
     * 插入排序：
     * 1. 将待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列
     * 2. 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     * （若待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面）
     * @param source
     * @return
     */
    public static int[] insertSort(int[] source){
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    /**
     * 快速排序：
     * 1. 从数列中挑出一个元素，称为基准(pivot)
     * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)。
     *   在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区操作。
     * 3. 递归地把 小于基准值元素的子数列和大于基准值元素的子数列排列
     * @param source
     * @return
     */
    public static int[] quickSort(int[] source){
        int[] arr = Arrays.copyOf(source,source.length);
        sort(arr,0,arr.length-1);
        return arr;
    }

    public static void sort(int[] arr,int low,int hight){
        int start = low;
        int end = hight;
        int key = arr[low];

        while (start < end){
            // 从后往前比较
            while (end > start && arr[end] >= key){
                // 若没有比关键值小的，比较下一个，知道有比关键值小的交换位置，然后又从前往后比较
                end --;
            }
            if(arr[end] <= key){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前往后比较
            while(end>start && arr[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }
            if(arr[start] >= key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，
            // 但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) {
            //左边序列。第一个索引位置到关键值索引-1
            sort(arr, low, start - 1);
        }
        if(end < hight) {
            //右边序列。从关键值索引+1到最后一个
            sort(arr, end + 1, hight);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,8,5,1,7};
        System.out.println("排序前："+ JSONObject.toJSONString(arr));
        arr = AlgorithmUtils.quickSort(arr);
        System.out.println("排序后："+ JSONObject.toJSONString(arr));
    }




























}
