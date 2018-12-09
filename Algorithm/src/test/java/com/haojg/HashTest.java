package com.haojg;

/**
 * @Author: 146477
 * @Date: 2018/8/9 12:28
 */
public class HashTest {
    public static void main(String[] args) {
        String key1 = "key:1";
        String key2 = "key:2";
        String key3 = "key:3";
        String key6 = "key:6";
        System.out.println(key1.hashCode() % 10);
        System.out.println(key2.hashCode() % 10);
        System.out.println(key3.hashCode() % 10);
        System.out.println(key6.hashCode() % 10);
    }
}
