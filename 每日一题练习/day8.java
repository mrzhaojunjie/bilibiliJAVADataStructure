package 每日一题;

import java.util.*;

public class day8 {

}
class Main81{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n > 1000){
            n = 999;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < n;i++){
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1){
            i = (i+2)%list.size();
            list.remove(i);
        }
        System.out.println(list.get(0));
    }
}
class Main82{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int[] array = new int[strs.length-1];
            for(int i=0;i < strs.length-1;i++){
                array[i] = Integer.valueOf(strs[i]);
            }
            int k = Integer.valueOf(strs[strs.length-1]);
            Arrays.sort(array);
            for(int i = 0;i < k;i++){
                System.out.print(array[i]);
                if(i!=k-1){
                    System.out.print(" ");
                }
            }
        }

    }
}
class Main83{
    public static void main(String[] args) {
        String x = "fmn";
        x.toUpperCase();
        String y = x.replace("f","F");
        y = y+"wxy";
        System.out.println(y);
    }
}

