package 每日一题;

import java.util.*;

public class day6 {
}
class Main62{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
            int half = list.size()/2;
            for(Integer e:list){
                map.put(e,map.getOrDefault(e,0)+1);
            }
            for(Integer e:map.keySet()){
                if(map.get(e) >= half){
                    System.out.println(Integer.valueOf(e));
                }
            }
        }
    }

class Main61{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int A = (m+p)/2;
            int B = (p-m)/2;
            int C = q-B;
            if(A-B==m && B-C==n && A+B==p && B+C==q){
                System.out.println(A+" "+B+" "+C);
            }else{
                System.out.println("No");
            }
        }
    }
}
