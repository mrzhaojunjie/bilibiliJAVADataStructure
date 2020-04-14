package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class day11 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                pong();
            }
        };
        t1.run();
        System.out.println("ping");
    }
    static void pong(){
        System.out.println("pong");
    }
}
class Main111{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            Map<Character,Integer> map = new HashMap<>();
            for(Character ch:s.toCharArray()){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }
    }
}
class Main112 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] before = new int[A.length];
        int[] after = new int[A.length];
        before[0] = 1;
        after[0] = 1;
        for(int i = 1;i < A.length;i++){
            before[i] = A[i-1]*before[i-1];
            after[i] = A[A.length-i]*after[i-1];
        }
        for(int i = 0;i < A.length;i++){
            B[i] = before[i]*after[A.length-i-1];
        }
        return B;
    }
}