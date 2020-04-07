package 每日一题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class day4 {
}
class solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n%2!=0){
                System.out.println(-1);
            }else{
                if(n%8 == 0){
                    System.out.println(n/8);
                }else{
                    System.out.println(1+n/8);
                }
            }
        }

    }

    public static String deleteSame(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            String A = scanner.nextLine();
            String B = scanner.nextLine();
            Set<Character> set = new HashSet<>();
            for(Character ch:B.toCharArray()){
                set.add(ch);
            }
            for(Character ch:A.toCharArray()){
                if(!set.contains(ch)){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
