package 排序算法;

import java.util.Arrays;

//快速排序是对冒泡排序的一种改进
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-9,78,0,23,-567,70,-1,900,4561};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];//中轴值
        int temp = 0;
        while (l < r) {
            //将小于pivot的值放在左边(否则跳出)  大于pivot的值放在右边
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            //找到了就交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完成后arr[l] == pivot, r--;前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完成后arr[r] == pivot, l++;后移
            if (arr[r] == pivot) {
                l += 1;
            }
            if (l == r) { //如果两坐标相等就错开
                l++;
                r--;
            }
            if (left < r) {   //如果left小于找到的r坐标就向左递归
                quickSort(arr, left, r);
            }
            if (right > l) {  //如果right大于找到的l坐标就向右递归
                quickSort(arr, l, right);
            }
        }
    }
}
