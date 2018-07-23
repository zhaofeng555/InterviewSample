package com.haojg;

/**
 * @Author: 146477
 * @Date: 2018/7/2 16:18
 */
public class HashCycleTest {
    class ListNode{
        int value;
        ListNode next;
    }
    public boolean hasCycle(ListNode head){
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
}
