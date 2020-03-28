package 分治算法;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }
    //分治算法进行解决
    public static void hanoiTower(int num,char a,char b,char c){
        if(num == 1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //先把最上面的所有盘A->B，中间借助c
            hanoiTower(num-1,a,c,b);
            //再把最下边的一个从A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //把B塔所有盘从B->C中间借助a
            hanoiTower(num-1,b,a,c);
        }
    }
}
