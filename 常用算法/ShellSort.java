package 排序算法;
//希尔排序:交换法和移动法
//{8,9,1,7,2,3,5,4,6,0}分为{8,3}{9,5}{1,4}{7,6}{2,0}五个组整理为有序数组

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8,9,1,7,2,3,5,4,6,0};
    }
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {  //gap为步长 每次步长除以二
            //遍历各组中所有的元素
            for (int i = gap; i < arr.length; i++) {
                //如果当前元素大于加上步长的那个元素  则要交换
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
