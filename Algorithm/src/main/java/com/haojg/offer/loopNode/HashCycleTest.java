package com.haojg.offer.loopNode;

import com.haojg.offer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 146477
 * @Date: 2018/7/lock 16:18
 */
public class HashCycleTest {

    public static boolean hasCycleValue(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.value == fast.value) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static ListNode findLoopNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode findLoopNodeValue(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.value == fast.value) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        testCycle();
    }

    private static void testCycle() {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, null);
        n1.next=n2;
        ListNode n3 = new ListNode(3, null);
        n2.next=n3;
        ListNode n4 = new ListNode(4, null);
        n3.next=n4;
        ListNode n5 = new ListNode(5, null);
        n4.next=n5;
        ListNode n6 = new ListNode(6, null);
        n5.next=n6;
        n6.next=n3;

        boolean b = hasCycle(n1);
        System.out.println(b);

        if(b){
            Set<ListNode> lnSet = new HashSet<>();
            ListNode cur=n1;
            while (cur!=null){
                if(lnSet.contains(cur)){
                    System.out.println(cur);
                    break;
                }
                lnSet.add(cur);
                cur = cur.next;
            }
        }
    }
    private static void testCycleVal() {
        ListNode n4 = new ListNode(2, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n5 = new ListNode(5, n3);
        ListNode n2 = new ListNode(2, n5);
        ListNode n1 = new ListNode(1, n2);

        n4.value = 2;
        n4.next = n2;

        boolean b = hasCycleValue(n1);
        System.out.println(b);

        ListNode loopNode = findLoopNode(n1);
        System.out.println(loopNode);
    }
}
