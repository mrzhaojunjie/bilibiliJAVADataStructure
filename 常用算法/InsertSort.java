package 排序算法;

import java.util.Arrays;
//{1,5,7,4,2}
//将{1}看为有序数组{5,7,4,2}看为无序数组
//在无序数组中依次找要插入的数
//要是比1小  则1往后移将找到的数放在1的前边构成有序数组
public class InsertSort {
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];  //要插入的值
            int insertIndex = i - 1; //要插入值的前一个数的下标
            //保证数组不越界  并且符合插入排序的条件
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//{1,5,7} 4
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 7, 4, 2};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
