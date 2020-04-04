package 每日一题;

import java.time.temporal.ChronoField;
import java.util.Scanner;
import java.util.Stack;

public class day3 {
}
/*class Main3{
    public static String findDigit(String str){

}*/
class test {
    public static void main(String[] args) {
        boolean b = chkParenthesis("()()((()))", 10);
        System.out.println(b);
       /* Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int max = 0,end = 0,count = 0;
            for(int i = 0;i < str.length();i++){
                if(Character.isDigit(str.charAt(i))){
                    count++;
                    if(count > max){
                        max = count;
                        end = i;
                    }
                }else{
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }*/
    }



    public static boolean chkParenthesis(String A, int n) {
        if(A.length()% 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        // write code here
        for (Character c : A.toCharArray()) {
            if(c !='('&& c !=')'){
                return false;
            }
            if(c == '('){
                st.push(c);
            }else if(c == ')'&& st.peek() == '('){
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
