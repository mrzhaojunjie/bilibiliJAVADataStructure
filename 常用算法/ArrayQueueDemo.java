package 稀疏数组和队列;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加元素");
            System.out.println("p(peek):取出队头");
            System.out.println("请选择：");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'p':
                    try {
                        int res = arrayQueue.peek();
                        System.out.println("队头为" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("已退出程序");
    }
}
class ArrayQueue{
    private int maxSize;  //最大容量
    private int front; //队头
    private int rear; //队尾
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    public boolean isFull(){
        return rear == maxSize-1;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void add(int val){
        if(isFull()){
            System.out.println("队列满，不能加入");
            return;
        }
        rear++;
        arr[rear] = val;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        front++;
        return arr[front];

    }
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }
    //显示队列的头部
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[front+1];
    }
}
