package 每日一题;

import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(cokecole(n,0,0));
        }
    }
    public static int cokecole(int n,int count,int sum){
        if(n < 3){
            if(n == 2){
                return sum+1;
            }else{
                return sum;
            }
        }
        count = n/3;
        sum += count;
        n = n%3 + count;
        return cokecole(n,count,sum);
    }
    public int count(int[] A, int n) {
        // write code here
        int count = 0;
        for(int i = 0;i < n-1;i++){
            for(int j = 0;j < n-i-1;j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
