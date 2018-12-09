package com.haojg.offer.printList;

import com.haojg.Node;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListTest {
    public static ArrayList<Integer> printListFromTailToHead1(Node<Integer> listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.value);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }

    public static ArrayList<Integer> printListFromTailToHead2(Node<Integer> listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.value);
        }
        return ret;
    }

    private static Node<Integer> generateNodeList() {
        Node<Integer> a = new Node<>(1, null);
        Node<Integer> b = new Node<>(2, a);
        Node<Integer> c = new Node<>(3, b);
        Node<Integer> d = new Node<>(4, c);
        Node<Integer> e = new Node<>(5, d);
        return e;
    }

    public static void main(String[] args) {
        Node<Integer> nodeList = generateNodeList();
        System.out.println(nodeList);

//        ArrayList<Integer> integers = printListFromTailToHead1(nodeList);
//        System.out.println(integers);

        ArrayList<Integer> integers2 = printListFromTailToHead2(nodeList);
        System.out.println(integers2);

    }


}
