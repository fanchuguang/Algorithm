package algorithm.datastructure.listnode;

/**
 * 双向链表
 */
public class DoubleNode {

    public int val;

    public DoubleNode pre;

    public DoubleNode next;

    public DoubleNode(int val, DoubleNode pre, DoubleNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

}
