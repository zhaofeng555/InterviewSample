package com.haojg;

public class ThreadDemo {
    public static void main(String[] args) {
        testThread();
    }

    static void testThread() {
        new Thread(() -> {
            System.out.println("hello");
        }).start();
    }
}