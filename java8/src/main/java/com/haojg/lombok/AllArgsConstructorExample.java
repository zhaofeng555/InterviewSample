package com.haojg.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor(staticName="newInstance")
public class AllArgsConstructorExample {

    private final String name;
    
    @NonNull
    @Getter
    private String age;
    
    private String sex;
    public static void main(String[] args) {
        AllArgsConstructorExample aace1 = new AllArgsConstructorExample("zhangsan", "18", "female");
        System.out.println(aace1.getAge());
        AllArgsConstructorExample aace2 = AllArgsConstructorExample.newInstance("lisi", "16", "male");
        System.out.println(aace2.getAge());
    }
}