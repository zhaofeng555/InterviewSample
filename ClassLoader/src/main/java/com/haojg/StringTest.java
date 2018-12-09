package com.haojg;

public class StringTest {
    public static void main(String[] args) {
        String[] arr = {"hello", "world"};
        String[] arr2 = new String[]{"hello", "world"};
        String[] arr3 = new String[2];
        arr3[0] = new String("hello");
        arr3[1] = new String("world");
        String h = "hello";
        System.out.println(arr[0] == h);
        System.out.println(arr2[0] == h);
        System.out.println(arr3[0] == h);
    }
}
