package 查找算法;
//线性查找
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr,11);
        if(index == -1){
            System.out.println("没有找到11");
        }else{
            System.out.println();
        }

    }
    public static int seqSearch(int[] arr,int value){
        //线性查找是逐一比对
        for(int i = 0; i<arr.length;i++){
            if(arr[i] == value ){
                return i;
            }
        }
        return -1;  //未找到返回-1
    }
}
