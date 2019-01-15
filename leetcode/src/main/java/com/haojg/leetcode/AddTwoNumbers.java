package com.haojg.leetcode;

import com.haojg.base.ListNode;

public class AddTwoNumbers {


    /**
     * 两个list 相加
     * input (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * output 7 -> 0 -> 8
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode();
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1=l1, p2 = l2;
        while(p1 != null || p2!=null){
            if(p1!=null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2!=null){
                sum += p2.val;
                p2 = p2.next;
            }

            cur.next = new ListNode(sum%10);
            sum /= 10;
            cur = cur.next;
        }

        if(sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next=l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next=l22;
        l22.next =l23;

        ListNode rs = addTwoNumbers(l11, l21);
        System.out.println(rs.toString());
    }

}
