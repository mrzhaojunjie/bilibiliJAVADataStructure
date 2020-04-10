package 每日一题;

import java.util.Scanner;

public class day7 {
}
class Main71{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int W = scanner.nextInt();
            int H = scanner.nextInt();
            int[][] array = new int[H][W];
            int max = 0;
            for(int i = 0;i < H;i++){
                if(i % 4 == 0||i % 4 == 1){
                    for(int j = 0;j < W;j++){
                        if(j % 4 == 0||j % 4 == 1){
                            array[i][j] = 1;
                        }
                    }
                }else{
                    for(int j = 0;j < W;j++){
                        if(j % 4 == 2||j % 4==3){
                            array[i][j] = 1;
                        }
                    }
                }
            }
            for(int i = 0;i < H;i++){
                for(int j = 0;j < W;j++){
                    if(array[i][j] == 1){
                        max++;
                    }
                }
            }


        }

    }
class Main72{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int GBS = num1*num2;
            int temp = 1;
            if(num1 < num2){
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            while (temp != 0){
                temp = num1 % num2;
                num1 = num2;
                num2 = temp;
            }
            GBS = GBS / num1;
            System.out.println(GBS);
        }
    }
}
