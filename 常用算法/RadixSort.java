package 排序算法;

import java.util.Arrays;

//基数排序
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];  //用来记录每次放入各个桶的数据以便之后取出
        int maxLength = (max + "").length();  //让max加上一个空串变成一个字符串求长度
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;  //对元素取个位
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];//对应的个位数的桶进行赋值
                bucketElementCounts[digitOfElement]++;//加入一个数据后  这个桶所记录的数据个数++
            }

            int index = 0;  //为了最后给原始数组赋值
            for (int k = 0; k < bucketElementCounts.length; k++) {   //遍历每个桶
                if (bucketElementCounts[k] != 0) {  //如果桶中有元素
                    for (int l = 0; l < bucketElementCounts[k]; l++) {  //遍历桶中的各个元素
                        arr[index] = bucket[k][l];   //将第k个桶中的第l个元素依次覆盖原数组
                        index++;   //并使下标++;就完成了第一次排序
                    }
                }
                bucketElementCounts[k] = 0;  //每次覆盖完后清空原来的桶
            }
        }

        //第一轮，针对每个元素的个位进行处理
        //定义一个二维数组表示十个桶;
        //每个一位数组大小定义为arr.length;
        //空间换时间的经典算法


       /* for(int j=0;j<arr.length;j++){
            int digitOfElement = arr[j]%10;  //对元素取个位
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];//对应的个位数的桶进行赋值
            bucketElementCounts[digitOfElement]++;//加入一个数据后  这个桶所记录的数据个数++
        }

        int index = 0;  //为了最后给原始数组赋值
        for(int k=0;k<bucketElementCounts.length;k++){   //遍历每个桶
            if(bucketElementCounts[k]!=0){  //如果桶中有元素
                for(int l = 0;l<bucketElementCounts[k];l++){  //遍历桶中的各个元素
                    arr[index] = bucket[k][l];   //将第k个桶中的第l个元素依次覆盖原数组
                    index++;   //并使小标++;就完成了第一次排序
                }
            }
        }*/
    }
}
