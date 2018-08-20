package com.haojg.lombok;

import lombok.Getter;
import lombok.NonNull;

public class NonNullExample {
    
    @Getter
    private String name;
    
    public NonNullExample(@NonNull String name){
        this.name = name;
    }
    
    public static void main(String[] args){
        String name = null;
        NonNullExample nne = new NonNullExample(name);
        System.out.println(nne.getName());
    }
}