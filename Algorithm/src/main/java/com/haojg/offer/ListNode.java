package com.haojg.offer;

public class ListNode {
    public ListNode() {
    }
    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public int value;
    public ListNode next;

    @Override
    public String toString() {
        return "[ListNode: curValue="+value+"]";
    }
}