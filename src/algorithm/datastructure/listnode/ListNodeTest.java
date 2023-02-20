package algorithm.datastructure.listnode;

/**
 * 链表的测试类
 */
public class ListNodeTest {

    public static void main(String[] args) {
        SingleNode singleNode = new SingleNode(1,new SingleNode(2,new SingleNode(3,null)));
        singleNode = reserveSingleNode(singleNode);
        singleNode = new SingleNode(1,null);
        singleNode = reserveSingleNode(singleNode);

        System.out.println("==============================");


        DoubleNode doubleNode1 = new DoubleNode(1,null,null);
        DoubleNode doubleNode2 = new DoubleNode(2,null,null);
        DoubleNode doubleNode3 = new DoubleNode(3,null,null);
        DoubleNode doubleNode4 = new DoubleNode(4,null,null);

        doubleNode1.next = doubleNode2;
        doubleNode2.next = doubleNode3;
        doubleNode3.next = doubleNode4;
        doubleNode2.pre = doubleNode1;
        doubleNode3.pre = doubleNode2;
        doubleNode4.pre = doubleNode3;

        doubleNode1 = reserveDoubleNode(doubleNode1);
        System.out.println("==============================");


    }


    /**
     * 反转单向链表
     * @param singleNode
     */
    public static SingleNode reserveSingleNode(SingleNode singleNode){

        SingleNode pre = null;
        SingleNode cur = singleNode;

        while (cur != null){
            SingleNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 反转双向链表
     * @param doubleNode
     */
    public static DoubleNode reserveDoubleNode(DoubleNode doubleNode){
        DoubleNode pre = null;
        DoubleNode cur = doubleNode;

        while (cur != null){
            DoubleNode next = cur.next;
            cur.next = pre;
            cur.pre = next;

            pre = cur;
            cur = next;
        }

        return pre;
    }

}
