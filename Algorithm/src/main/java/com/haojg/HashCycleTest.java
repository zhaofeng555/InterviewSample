package com.haojg;

/**
 * @Author: 146477
 * @Date: 2018/7/2 16:18
 */
public class HashCycleTest {
    static class ListNode{
        public ListNode(int value, ListNode next){
            this.value=value;
            this.next=next;
        }

        int value;
        ListNode next;
    }

    public static boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1!=null && l2 !=null && l2.next!=null){
            if(l1.value == l2.value){
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(2, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n4.value=2;
        n4.next=n2;

        boolean b = hasCycle(n1);
        System.out.println(b);
    }
}
