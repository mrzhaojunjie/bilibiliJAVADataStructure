package 查找算法;

import java.util.ArrayList;

//该数组必须有序
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        binarySearch(arr, 0, arr.length, 1234);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        for (int i = 0; i < arr.length; i++) {
            if (findVal > midVal) {
                return binarySearch(arr, mid + 1, left, findVal);
            } else if (findVal < midVal) {
                return binarySearch(arr, left, mid - 1, findVal);
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static ArrayList<Integer> binarySearch1(int[] arr,int left,int right,int findVal){
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        for (int i = 0; i < arr.length; i++) {
            if (findVal > midVal) {
                return binarySearch1(arr, mid + 1, left, findVal);
            } else if (findVal < midVal) {
                return binarySearch1(arr, left, mid - 1, findVal);
            } else {   //findVal == midVal
                //然后分别向左向右查找
                ArrayList<Integer> list = new ArrayList<>();
                int temp = mid - 1;
                while (true) {
                    if (temp < 0 || arr[temp] != findVal) {
                        break;
                    }
                    list.add(temp);
                    temp -= 1;
                }
                list.add(mid);   //本来已经找到的下标
                while (true) {
                    if (temp > arr.length - 1 || arr[temp] != findVal) {
                        break;
                    }
                    list.add(temp);
                    temp += 1;
                }
                return list;
            }
        }
        return new ArrayList<>();
    }
}
