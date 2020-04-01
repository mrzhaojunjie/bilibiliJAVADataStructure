package 哈希表;

import java.util.Scanner;

//哈希表同时管理多条链表
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTab = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add :  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTable {
    private EmployeeLinkedList[] LinkedListArr;
    private int size;  //共有多少条链表

    public HashTable(int size) {
        this.size = size;
        LinkedListArr = new EmployeeLinkedList[size];
        for(int i = 0;i<size;i++){
            LinkedListArr[i] = new EmployeeLinkedList(); //初始化每条链表
        }
    }

    public void add(Emp emp) {
        //根据员工id得到该员工应当添加到哪条链表
        int empLinkedListNumber = hashFun(emp.id);
        LinkedListArr[empLinkedListNumber].add(emp);
        }
    public void list(){
        for(int i = 0;i<size;i++){
            LinkedListArr[i].list(i);
        }
    }
    public void findEmpById(int id){
         int empLinkedListNo = hashFun(id);
         Emp emp = LinkedListArr[empLinkedListNo].findEmpById(id);
         if(emp != null){
             System.out.println();
         }else{
             System.out.println("未找到");
         }

    }

    public int hashFun(int id) {
        return id % size;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;  //next默认为空
    public Emp(int id,String name){
        this.id = id;
        this.name = name;
    }
}
class EmployeeLinkedList{   //表示链表
    private Emp head;//默认为空

    public void add(Emp emp){
        if(head == null){
            head = emp;
        }
        Emp cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = emp;
    }
    //遍历雇员信息
    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"条链表暂无员工信息");
            return;
        }
        Emp cur = head;
        while(cur.next!=null){
            System.out.println("第"+no+"条链表信息为员工id=>"+cur.id+",员工姓名=>"+cur.name);
            cur = cur.next;
        }
    }
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
        }
        Emp cur = head;
        while(true){
            if(cur.id == id){
                break;
            }
            if(cur.next == null){
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}
