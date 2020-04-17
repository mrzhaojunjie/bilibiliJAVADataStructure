package 每日一题;

import java.util.Arrays;
import java.util.Scanner;

public class day13 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                dianping();
            }
        };
        t.run();
        System.out.println("dazhong");
    }
    static void dianping(){
        System.out.println("dianping");
    }
}
class test1{
    static boolean out(char c){
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for(out('A');out('B')&&i < 2;out('C')){
            i++;
            out('D');
        }
    }
}
class Main131{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            String s = scanner.next();
            char C = s.charAt(0);
            for(int i = 0;i < N+1/2;i++){
                for(int j = 0;j < N;j++){
                    if(i == 0||j == 0||i == (((N+1)/2)-1)||j == N-1){
                        System.out.print(C);
                    }else{
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
class Main132{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String addend = scanner.next();
            String augend = scanner.next();
            int len1 = addend.length();
            int len2 = augend.length();
            int resLen = Math.max(len1,len2);

            int[] arr1 = new int[resLen];
            int[] arr2 = new int[resLen];
            int[] arrRes = new int[resLen+1];

            for(int i = 0;i < arr1.length;i++){
                arr1[i] = addend.charAt(len1 - 1 - i)-'0';
            }
            for(int i = 0;i < arr2.length;i++){
                arr2[i] = augend.charAt(len2 - 1 - i)-'0';
            }
            for(int i = 0;i < resLen;i++){
                int sum = arrRes[i]+arr1[i]+arr2[i];
                int flag = sum/10;
                arrRes[i] = sum %10;
                arrRes[i+1] += flag;
            }
            for(int i = arrRes[resLen-1] == 0?1:0;i < resLen;i++){
                System.out.print(arrRes[resLen-i]);
            }
            System.out.println();
        }
        scanner.close();
    }



}