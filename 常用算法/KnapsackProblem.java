package 动态规划;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,3,4};  //物品的重量
        int[] val = {1500,3000,2000};   //v[i],物品的价值
        int m = 4;  //背包的容量
        int n = val.length;
        //创建二维数组，v[i][j]表示在前i个物品中能够装入容量为j的背包的最大家族
        int[][] v = new int[n+1][m+1];
        for(int i = 0;i<v.length;i++){
            v[i][0] = 0;  //将第一列设为0
        }
        for(int i = 0;i<v[0].length;i++){
            v[0][i] = 0;  //将第一行设为0
        }
        for(int i = 0;i<v.length;i++){
            for(int j = 0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        for(int i = 1;i<v.length;i++){
            for(int j =1;j<v[0].length;j++){
                if(w[i-1]>j){
                    v[i][j] = v[i-1][j];
                }else{
                    v[i][j] = Math.max(v[i-1][j],v[i-1][j-w[i-1]]+val[i-1]);
                }
            }
        }
    }
}
