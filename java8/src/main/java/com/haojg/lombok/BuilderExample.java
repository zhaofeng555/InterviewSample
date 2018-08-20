package com.haojg.lombok;

import lombok.Builder;

@Builder
public class BuilderExample {
    private String name;
    private String age;
    private String sex;
    public static void main(String[] args) {
        BuilderExample be = BuilderExample.builder().name("zhangsan").age("16").sex("male").build();
        
        System.out.println(BuilderExample.builder().name("zhangsan").age("16").sex("male"));
    }
}