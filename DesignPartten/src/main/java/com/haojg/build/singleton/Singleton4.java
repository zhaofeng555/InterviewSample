package com.haojg.build.singleton;

public class Singleton4 {
//    private volatile static Singleton4 instance;
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        System.out.println("first check");
        if (instance == null) {
            System.out.println("second check");
            synchronized (Singleton4.class) {
                System.out.println("third check");
                if (instance == null) {
                    System.out.println("forth check");
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->System.out.println(Singleton4.getInstance())).start();
        }
    }



}
