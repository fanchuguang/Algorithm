package test;

public class Test {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,null)))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,null)));
//        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,new ListNode(9,null))));
        Solution.addTwoNumbers(l1,l2);

    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            l1 = reserve(l1);
//            l2 = reserve(l2);

            ListNode res = null;

            ListNode l1Cur = l1 ,l2Cur = l2;
            boolean bit = false;

            while(l1Cur != null || l2Cur != null){
                int l1Val = l1Cur == null ? 0 : l1Cur.val;
                int l2Val = l2Cur == null ? 0 : l2Cur.val;

                int plus = l1Val + l2Val +( bit?1:0);
                bit = plus >= 10;
                res = new ListNode(plus >= 10 ? (plus - 10) : plus,res);

                if(l1Cur == null){
                    l2Cur = l2Cur.next;
                }else if(l2Cur == null){
                    l1Cur = l1Cur.next;
                }else{
                    l2Cur = l2Cur.next;
                    l1Cur = l1Cur.next;
                }
            }

            if(bit){
                res = new ListNode(1,res);
            }


            return reserve(res);

        }

        public static ListNode reserve(ListNode listNode){
            ListNode pre = null;
            ListNode cur = listNode;
            while(cur != null){
                ListNode nextCur = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextCur;
            }


            return pre;
        }
    }
}
