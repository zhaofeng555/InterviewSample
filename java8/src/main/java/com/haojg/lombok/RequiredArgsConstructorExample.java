package com.haojg.lombok;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName="newInstance")
public class RequiredArgsConstructorExample {

    private final String name;
    
    @NonNull
    @Getter
    private String age;
    
    private String sex;
    
    public static void main(String[] args) {
        RequiredArgsConstructorExample race1 = new RequiredArgsConstructorExample("lisi", "18");
        System.out.println(race1.getAge());
        RequiredArgsConstructorExample race2 = RequiredArgsConstructorExample.newInstance("zhangsan", "16");
        System.out.println(race2.getAge());
    }
}