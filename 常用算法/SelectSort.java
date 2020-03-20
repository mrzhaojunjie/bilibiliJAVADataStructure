package 排序算法;

import java.util.Arrays;
//选择排序   时间复杂度为O(n^2)
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1, 6, 47, 8, 7};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {  //先找到数组中的最小值
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {  //如果最小值不是同一个数则要进行交换  否则则不需要
                arr[minIndex] = arr[i];  //将0下标处的数赋值给最小值下标处的数
                arr[i] = min;    //将找到的最小值赋给0下标处的值以完成交换
            }
        }
    }
}
