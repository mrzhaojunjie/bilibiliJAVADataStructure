package 稀疏数组和队列;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组 11*11
        //0 表示无子，1表示黑子 2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[3][4] = 2;
        System.out.println("原始二维数组为：");
        for(int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        int sum = 0;
        for(int i = 0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum+=1;
                }
            }
        }
        //创建对应稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        //稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历原始数组
        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组为");
        for(int i = 0;i < sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
            System.out.println();
        }

        //将稀疏数组恢复为原始二维数组

        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i < sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println();
        for(int[] row:chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
