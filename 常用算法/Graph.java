package 图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;   //存储对应的顶点
    private int[][] edges; //存储对应的邻接矩阵
    private int numOfEdges;  //表示边的数目
    private boolean[] isVisited;
    public static void main(String[] args) {
        int n = 5;
        String Vetexs[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for(String vertex: Vetexs){
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
        /*System.out.println("深度优先搜索");
        graph.DFS();*/
        System.out.println("广度优先搜索");
        graph.BFS();
    }

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
    //返回顶点的数目
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的条数
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //返回邻接矩阵中的权值  1代表两条边相关，0代表不相关
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //按照索引返回顶点 0->A 1->B 2->C......
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getFirstNeighbor(int index) {   //获取index的第一个邻接点
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先搜索遍历DFS
    private void DFS(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"->");//先打印该顶点
        isVisited[i] = true;  //访问过后标记
        int w = getFirstNeighbor(i); //w为访问过的顶点的第一个邻接点
        while(w!=-1){ //w存在
            if(!isVisited[w]){  //若w没有被访问
                DFS(isVisited,w);   //递归深度优先搜索
            }
            //如果w被访问过  w就等于i的另一个没被访问过得邻接点
            w = getNextNeighbor(i,w);
        }
    }
    public void DFS(){
        for(int j = 0;j<getNumOfVertex();j++ ){  //遍历所有顶点
            if(!isVisited[j]){   //如果没有被访问，则深度优先搜索
                DFS(isVisited,j);
            }
        }
    }
    public void BFS(boolean[] isVisited,int i){
        int u; //
        int w; //
        LinkedList queue = new LinkedList();  //用LinkedList代替队列
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);  //队尾插入i顶点
        while(!queue.isEmpty()){   //如果队列不为空
            u = (Integer)queue.removeFirst(); //出队并用u标记
            w = getFirstNeighbor(u);  //w标记队首的第一个邻接点
            while(w!=-1){  //找到
                if(!isVisited[w]){   //如果w未被访问过则访问并标记为已访问
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);  //访问完后继续将w入队
                }
                w = getNextNeighbor(u,w); //w又变为u的另一个邻接点
            }
        }

    }
    public void BFS(){
        for(int i = 0;i<getNumOfVertex();i++){
            if(!isVisited[i]){
                BFS(isVisited,i);
            }
        }
    }
    public void showGraph(){   //打印邻接矩阵
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

}
