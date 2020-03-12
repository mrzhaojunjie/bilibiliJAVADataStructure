package 赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("空树");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        //第一步为了操作方便
        //遍历arr数组
        //将arr的每个元素构建成一个Node
        //将Node放入ArrayList中
        List<Node> nodes = new ArrayList<>();
        for(int value:arr){
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);   //排序
            System.out.println(nodes);
            Node leftNode = nodes.get(0);   //获得权值最小的结点为左节点
            Node rightNode = nodes.get(1);  //次小的为右节点
            Node parent = new Node(leftNode.value + rightNode.value);  //两个相加构成新节点
            parent.left = leftNode;  //把左右节点跟父节点挂钩
            parent.right = rightNode;
            nodes.remove(leftNode);  //在list中删除左右节点并加入新的父节点
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}
class Node implements Comparable<Node>{
    public int value;//结点权值
    public Node left;  //左子节点
    public Node right;//右子节点
    public Node(int value){
        this.value = value;
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }

    }
    public void midOrder(){  //中序遍历
        if(this.left!=null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node [value="+value+"]";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
