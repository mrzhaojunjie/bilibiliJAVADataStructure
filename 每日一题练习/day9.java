package 每日一题;

import java.util.Scanner;
import java.util.Stack;

public class day9 {
}
class Main91{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int res = 0;
            for(int i = n;i >=5;i--){
                int temp = i;
                while (temp % 5 == 0){
                    res++;
                    temp = temp / 5;
                }
            }
            System.out.println(res);
        }
    }
}
class Main92{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            while (n > 0){
                sb.append(n%10);
                n = n / 10;
            }
            System.out.println(sb);
        }
    }
}
