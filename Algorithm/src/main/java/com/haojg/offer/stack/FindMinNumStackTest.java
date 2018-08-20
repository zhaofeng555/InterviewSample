package com.haojg.offer.stack;

import java.util.Stack;

/**
 * @Author: 146477
 * @Date: 2018/8/10 14:23
 */
public class FindMinNumStackTest {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        FindMinNumStackTest fmn = new FindMinNumStackTest();
        int num[]={5,3,6,8,2,9};
        for (int i = 0; i < num.length; i++) {
            fmn.push(num[i]);
        }
        System.out.println(fmn.top());
        System.out.println(fmn.min());
    }
}
