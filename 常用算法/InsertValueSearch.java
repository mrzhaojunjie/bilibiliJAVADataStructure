package 查找算法;
//插值查找相当于二分查找的升级
//二分查找递归次数为logn;n为元素个数
//插值算法一次精准定位 mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left])
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValSearch(arr,0,arr.length-1,47);
        System.out.println(index);
    }

    public static int insertValSearch(int[] arr,int left,int right,int findVal){
        System.out.println("hello~~~");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {//必须有的终止条件，没有的话mid可能越界
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if(findVal > midVal){
            return insertValSearch(arr,mid+1,right,findVal);
        }else if(findVal < midVal){
            return insertValSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
