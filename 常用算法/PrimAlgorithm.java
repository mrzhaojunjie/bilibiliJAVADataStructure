package PrimAlgorithm;

import java.util.Arrays;
//普利姆算法MST最小生成树解决村庄间修路问题
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int vertexs = data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };
        MGraph graph = new MGraph(vertexs);
        minTree minTree = new minTree();
        minTree.createGraph(graph,vertexs,data,weight);
        minTree.showGraph(graph);
        minTree.prim(graph,0);
    }
}
class minTree{
    public void createGraph(MGraph graph, int vertexs, char data[], int[][] weight) {
        for (int i = 0; i < vertexs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertexs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    public void showGraph(MGraph graph){
        for(int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
    public void prim(MGraph graph,int v){   //v表示从哪个v顶点开始生成
        //visited[]标记顶点是否被访问过
        int[] visited = new int[graph.vertxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.vertxs; k++) {   //普利姆算法生成graph.vertxs-1条边
            for (int i = 0; i < graph.vertxs; i++) {  //i表示访问过得点
                for (int j = 0; j < graph.vertxs; j++) {  //j表示未访问过的点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                    //如果i顶点访问过j顶点未访问过并且两个顶点间的权值小于minWeight
                        //记录下i 和 j
                        h1 = i;
                        h2 = j;
                        minWeight = graph.weight[i][j];
                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+">  权值："+minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }

    }
}

class MGraph {
    int vertxs; //顶点个数
    char[] data;  //顶点的值abcd
    int[][] weight;  //邻接矩阵

    public MGraph(int vertxs) {
        this.vertxs = vertxs;
        data = new char[vertxs];
        weight = new int[vertxs][vertxs];
    }
}
