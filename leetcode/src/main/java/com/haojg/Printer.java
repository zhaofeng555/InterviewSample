package com.haojg;

public class Printer {
    public static void print(Object[] arr){
        for(Object o: arr){
            System.out.print(o);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void print(int[] arr){

        for(Object o: arr){
            System.out.print(o);
            System.out.print(", ");
        }
        System.out.println();

    }

}
