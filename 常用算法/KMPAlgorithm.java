package KMP;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BABACDADBCD";
        String str2 = "BACDA";
        int[] next = kmpNext(str2);
        int index = kmpSearch(str1,str2,next);
        System.out.println(index);
    }
    //获取子串的部分匹配值
    public static int[] kmpNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;   //字符串长度为1，前缀后缀无交集
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //核心部分
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
