package 二叉排序树;

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for(int i =0;i<arr.length;i++){
            Node node = new Node(arr[i]);
            binarySearchTree.add(node);
        }
        binarySearchTree.infixOrder();
    }
}
class BinarySearchTree{
    private  Node root;
    public void add(Node node){
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;
    public Node(int value){
        this.value = value;
    }

    public void add(Node node){
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            //如果当前结点左子树为空直接挂上
            if (this.left == null) {
                this.left = node;
            } else {   //如果不为空
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
    public void infixOrder(){
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}