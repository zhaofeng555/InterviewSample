package com.haojg.lombok;

import lombok.ToString;

@ToString
public class ToStringExample {

    @ToString.Exclude
    private String name;

    @ToString.Include
    private String age;

    private String sex;

    public static void main(String[] args) {
        ToStringExample tse = new ToStringExample();
        System.out.println(tse.toString());
    }
}