package com.haojg.base;


import lombok.Data;

@Data
public class ListNode {

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public int val;
    public ListNode next;

}
