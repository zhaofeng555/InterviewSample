package com.haojg.collection;

import java.util.LinkedList;

public class SortList extends LinkedList<SortList.MyNode> {

    public synchronized void insertAndSort(MyNode n) {

        int insertIndex = 0;
        int len = size();
        for (int i = 0; i < len; i++) {
            MyNode curNode = get(i);

            if (curNode.sortCode <= n.sortCode) {
                break;
            }
            insertIndex = i+1;
        }

        add(insertIndex, n);
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        MyNode n2 = new MyNode(2, "name2");
        MyNode n1 = new MyNode(1, "name1");
        MyNode n3 = new MyNode(3, "name3");
        MyNode n4 = new MyNode(4, "name4");
        MyNode n5 = new MyNode(5, "name5");
        MyNode n6 = new MyNode(3, "name6");
        sl.insertAndSort(n2);
        sl.insertAndSort(n1);
        sl.insertAndSort(n4);
        sl.insertAndSort(n3);
        sl.insertAndSort(n5);
        sl.insertAndSort(n6);
        System.out.println(sl);

        for (int i = 0; i < 2; i++) {
            MyNode myNode = sl.removeLast();
            ++myNode.useCount;
            ++myNode.sortCode;
            sl.insertAndSort(myNode);
        }

        System.out.println(sl);
    }


    static class MyNode {
        public int sortCode;
        public String name;
        public int useCount;

        public MyNode(int sortCode, String name) {
            this.sortCode = sortCode;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[code=" + this.sortCode + ", name=" + name + ", useCount="+useCount+"]";
        }
    }

}

