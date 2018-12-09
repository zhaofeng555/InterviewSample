package com.haojg.lombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashcodeExample {

    private String name;
    private String age;
    private String sex;

    public static void main(String[] args) {
        EqualsAndHashcodeExample ehe1 = new EqualsAndHashcodeExample();
        EqualsAndHashcodeExample ehe2 = new EqualsAndHashcodeExample();
        System.out.println(ehe1.equals(ehe2));
        System.out.println(ehe1.hashCode());
        System.out.println(ehe2.hashCode());
    }
}