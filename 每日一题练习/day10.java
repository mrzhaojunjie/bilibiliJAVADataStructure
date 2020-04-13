package 每日一题;

import java.util.Scanner;

public class day10 {}
class Main101{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(Fibonacci(n));
        }
    }
    public static int Fibonacci(int n){
        int F1 = 0;
        int F2 = 1;
        while (true){
            int fib = F1 + F2;
            F1 = F2;
            if(fib >= n){
                return Math.min(fib-n,n-F2);
            }
            F2 = fib;
        }
    }
}
class Main102{
    public int countWays(int x, int y) {
        // write code here
        int[][] array = new int[13][13];
        for(int i = 1;i < x;i++){
            array[i][0] = 1;
        }
        for(int j = 1;j < y;j++){
            array[0][j] = 1;
        }
        for(int i = 1;i < x;i++){
            for(int j = 1;j < y;j++){
                array[i][j] = array[i-1][j]+array[i][j-1];
            }
        }
        return array[x-1][y-1];
    }
}
