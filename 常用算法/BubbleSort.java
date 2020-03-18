package 排序算法;

import java.util.Arrays;

//冒泡排序：一共进行array.length-1次排序
//每趟排序的次数逐渐减少
//若某趟排序中没有一次数据交换  则可以提前结束冒泡排序（优化）
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false; //标识符
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;   //若进行过交换  flag为true
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后");
            System.out.println(Arrays.toString(arr));
            if (!flag) {  //一次都没有交换则跳出循环排序完毕
                break;
            } else {
                flag = false;  //重置标识符
            }

        }
    }
    public static void main(String[] args) {
        /*int[] array = {1,6,4,9,5,2,7};
        bubbleSort(array);*/
        int[] arrayBig = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arrayBig[i] = (int) (Math.random() * 8000000);
        }
        bubbleSort(arrayBig);
    }
}
