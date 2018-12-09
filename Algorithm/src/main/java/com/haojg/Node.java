package com.haojg;

public class Node<T> {
    public T value;
    public Node<T> next;


    public Node(T value, Node<T> next) {
        this.next = next;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " , ";
    }


}