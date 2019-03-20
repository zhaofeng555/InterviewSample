package com.haojg.link;

public class Node {
    int index;
    Node next;

    public Node(int index, Node next) {
        this.index = index;
        this.next = next;
    }


    public Node reverse(Node node) {
        Node prev = null;
        Node now = node;
        while (now != null) {
            Node next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }

        return prev;
    }

    public Node reverse2(Node node, Node prev) {
        if (node.next == null) {
            node.next = prev;
            return node;
        } else {
            Node re = reverse2(node.next, node);
            node.next = prev;
            return re;
        }
    }


    public Node reverse3(Node node) {
        if (node.next == null) return node;
        Node next = node.next;
        node.next = null;
        Node re = reverse3(next);
        next.next = node;
        return re;
    }
}