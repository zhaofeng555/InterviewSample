package com.haojg.offer.loopNode;

import com.haojg.offer.ListNode;

/**
 * @Author: 146477
 * @Date: 2018/7/lock 16:18
 */
public class HashCycleTest {

    public static boolean hasCycle(ListNode head) {
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

    public static ListNode findLoopNode(ListNode pHead) {
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
        ListNode n4 = new ListNode(2, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n4.value = 2;
        n4.next = n2;

        boolean b = hasCycle(n1);
        System.out.println(b);

        ListNode loopNode = findLoopNode(n1);
        System.out.println(loopNode);

    }
}
