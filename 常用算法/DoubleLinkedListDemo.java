package 链表;

import java.awt.*;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}
class DoubleLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    public HeroNode getHead(){
        return head;
    }
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(temp!=null){
            temp = temp.next;
        }
        //此时temp为最后一个节点
        temp.next = heroNode;   //最后节点的后继指向新结点
        heroNode.pre = temp;  //新结点的前驱指向最后节点
    }

    //双向链表节点的内容修改只是节点类型的改变
    public void update(HeroNode newheroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;   //是否找到要更新节点的标志
        while(temp!=null){
            if(temp.no == newheroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){   //找到后更新
            temp.name = newheroNode.name;
            temp.nickname = newheroNode.nickname;
        }else{
            System.out.println("没有找到该结点");
        }
    }

    //删除双向链表中的节点
    public void delete(int no){
        if(head.next == null){
            System.out.println("空链表");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while(temp!=null){
            if(temp.no == no){
                flag = true;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }

        }
        System.out.println("删除成功");
    }

}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //后继结点
    public HeroNode pre;//前驱结点
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no ="+no+",name = "+name+",nickname = "+nickname+",next = "+next+",pre = "+pre+"]";
    }
}
