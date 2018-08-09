package com.haojg.offer.revese;

import com.haojg.Node;

import java.util.Stack;

/**
 * Function: 三种方式反向打印单向链表
 *
 * @author crossoverJie
 *         Date: 10/02/2018 16:14
 * @since JDK 1.8
 */
public class ReverseNode {

    public static void main(String[] args) {

        ReverseNode rn = new ReverseNode();

//        rn.reverseNode1(generateNodeList());

        Node<String> s = generateNodeList();
        print(s);
//        rn.reverseNode(s);
        rn.recNode(s);

//        rn.recNode(generateNodeList());
    }

    private static Node<String> generateNodeList(){
        Node<String> a = new Node<>("a", null);
        Node<String> b = new Node<>("b", a);
        Node<String> c = new Node<>("c", b);
        Node<String> d = new Node<>("d", c);
        Node<String> e = new Node<>("e", d);
        return e;
    }

    private static void print(Node<String> node){
        //遍历新链表
        while (node != null){
            System.out.print(node.value+" => ");
            node = node.next ;
        }
        System.out.println();
        System.out.println("========end=======");
    }


    /**
     * 利用栈的先进后出特性
     * @param node
     */
    public void reverseNode1(Node node){

        System.out.println("====翻转之前====");

        Stack<Node> stack = new Stack<>() ;
        while (node != null){

            System.out.print(node.value + "===>");

            stack.push(node) ;
            node = node.next ;
        }

        System.out.println("");

        System.out.println("====翻转之后====");
        while (!stack.isEmpty()){
            System.out.print(stack.pop().value + "===>");
        }

    }


    /**
     * 利用头插法插入链表
     * @param head
     */
    public  void reverseNode(Node head) {
        if (head == null) {
            return ;
        }

        //最终翻转之后的 Node
        Node node ;

        Node pre = head;
        Node cur = head.next;
        Node next ;
        while(cur != null){
            next = cur.next;

            //链表的头插法
            cur.next = pre;
            pre = cur;

            cur = next;
        }
        head.next = null;
        node = pre;

        System.out.println("翻转之后的：");
        //遍历新链表
        while (node != null){
            System.out.print(node.value+" => ");
            node = node.next ;
        }
    }


    /**
     * 递归
     * @param node
     */
    public void recNode(Node node){

        if (node == null){
            return ;
        }

        if (node.next != null){
            recNode(node.next) ;
        }
        System.out.print(node.value+"===>");
    }



}