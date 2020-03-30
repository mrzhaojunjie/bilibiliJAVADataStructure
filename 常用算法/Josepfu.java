package 链表;

public class Josepfu {
    public static void main(String[] args) {
        circleLinkedList circleLinkedList  = new circleLinkedList();
        circleLinkedList.addBoy(5); //加入五个孩子
        circleLinkedList.showBoy();

    }
}


//创建环形单向链表
class circleLinkedList{
    //创建first节点，无编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构成环形链表
    public void addBoy(int nums){   //nums为节点数
        if(nums < 1){
            System.out.println("至少添加一个节点");
            return;
        }
        Boy curboy = null; //辅助指针帮助构建环形链表
        //用for循环创建环形链表
        for(int i = 1;i<=nums;i++){
            //根据编号创建结点
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.next = first;  //构成环
                curboy = first;
            }else{
                curboy.next = boy;
                boy.next = first;
                curboy = boy;
            }
        }
    }
    //遍历当前环形链表
    public void showBoy(){
        //判断链表是否为空
        if (first == null){
            System.out.println("链表为空");
            return;
        }
        //first不能动，用辅助指针遍历
        Boy curBoy = first;
        while(curBoy.next != first){   //当辅助结点指向首节点first时结束遍历
            System.out.printf("小孩的编号为：%d\n",curBoy.getNo()); //打印小孩编号
            curBoy = curBoy.next; //辅助结点后移继续遍历
        }
    }
    //根据用户输入，计算出出圈的顺序
//    startNum表示从几号小孩开始
//    countNum表示数几次
//    nums表示刚开始一共几个小孩
    public void countBoy(int startNum,int countNum,int nums){
        if(first == null||startNum < 1||startNum > nums){
            System.out.println("参数有误");
            return;
        }
        //创建辅助指针
        Boy helper = first;
        while(helper.next != first){
            helper = helper.next;
        }
        //报数前先让first和helper移动k-1次
        for(int j = 0;j < startNum -1;j++){
            first = first.next;
            helper = helper.next;
        }
        //当小孩报数时，让first和helper同时移动m-1次
        //知道圈中只有一个节点
        while (true){
            if(helper == first){//圈中只有一个人
                break;
            }
            //让helper和first同时移动countNum-1次  然后出圈
            for (int j = 0;j < countNum -1;j++){
                first = first.next;
                helper = helper.next;
            }
            //此时first指向的结点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first节点的小孩出圈
            first = first.next;
            helper.next = first;

        }
        System.out.printf("最后留在圈中的小孩编号为%d\n",first.getNo());
    }
}
//创建Boy类表示节点
class Boy{
    public int no; //编号
    public Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }



}