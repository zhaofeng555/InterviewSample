package com.haojg.offer.merge;

import com.haojg.offer.ListNode;

/**
 * @Author: 146477
 * @Date: 2018/8/8 17:03
 */
public class MergeListTest {

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.value <= node2.value) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }

    public ListNode merge2(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        return null;
    }

    public static void main(String[] args) {
        int size = 8;
        int newSize = 16;
        int num = 11;
        int num2 = 3;
        System.out.println(num % size);
        System.out.println(num % newSize);

        System.out.println(num & size);
        System.out.println(num2 & size);

    }

}
