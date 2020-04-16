package 每日一题;

public class day12 {
}
class day121{
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }
}
class day122{
    public String[] getGray(int n) {
        // write code here
        String[] res = null;
        if(n == 1){
            res = new String[]{"0","1"};
        }else{
            String[] str = getGray(n - 1);
            res = new String[2 * str.length];
            for (int i = 0; i < str.length; i++) {
                res[i] = "0" + str[i];
                res[res.length - 1 - i] = "1" + str[i];
            }
        }
        return res;
    }
}
