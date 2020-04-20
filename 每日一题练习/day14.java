package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day14 {

}
class Main141{
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 10;i++){
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int i = 0;
        while (i < 10){
            if(array[0] != 0){
                break;
            }
            if(array[i] == 0){
                i++;
            }else{
                swap(array,0,i);
                break;
            }
        }
        for(int j = 0;j < 10;j++){
            sb.append(array[j]);
        }
        System.out.println(sb.toString());
    }
}
class Main142{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            GetSequeOddNum(m);
        }
    }
    public static String GetSequeOddNum(int m){
        int first =(int) Math.pow(m,2)-m+1;
        int[] res = new int[m];
        res[0] = first;
        for(int i = 1;i < m;i++){
            res[i] = first+2;
            first = res[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < m;i++){
            if(i == m-1){
                System.out.print(res[i]);
                break;
            }
            System.out.print(res[i]+"+");
        }
        return null;
    }
}