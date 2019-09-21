package com.haojg.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortListTest {

    static LinkedList<MyNode> sortList = new LinkedList<>();
    static LinkedList<MyNode> sortList2 = new LinkedList<>();

    public synchronized static void insertAndSort(MyNode n) {

        int insertIndex = 0;
        int len = sortList2.size();
        for (int i = 0; i < len; i++) {
            MyNode curNode = sortList2.get(i);

            if (curNode.sortCode <= n.sortCode) {
                break;
            }
            insertIndex = i+1;
        }

        sortList2.add(insertIndex, n);
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        MyNode n2 = new MyNode(2, "name2");
        MyNode n1 = new MyNode(1, "name1");
        MyNode n3 = new MyNode(3, "name3");
        MyNode n4 = new MyNode(3, "name4");
        MyNode n5 = new MyNode(5, "name5");
        sortList.add(n2);
        sortList.add(n1);
        sortList.add(n3);
        sortList.add(n4);
        sortList.add(n5);

        Collections.sort(sortList, new Comparator<MyNode>() {
            @Override
            public int compare(MyNode o1, MyNode o2) {
                return o2.sortCode - o1.sortCode;
            }
        });

        System.out.println(sortList);
    }

    private static void test2() {
        MyNode n2 = new MyNode(2, "name2");
        MyNode n1 = new MyNode(1, "name1");
        MyNode n3 = new MyNode(3, "name3");
        MyNode n4 = new MyNode(3, "name4");
        MyNode n5 = new MyNode(5, "name5");
        MyNode n6 = new MyNode(3, "name6");
        insertAndSort(n2);
        insertAndSort(n1);
        insertAndSort(n4);
        insertAndSort(n3);
        insertAndSort(n5);
        insertAndSort(n6);

        System.out.println(sortList2);
    }

    static class MyNode {
        public int sortCode;
        public String name;

        public MyNode(int sortCode, String name) {
            this.sortCode = sortCode;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[code=" + this.sortCode + ", name=" + name + "]";
        }
    }

}

