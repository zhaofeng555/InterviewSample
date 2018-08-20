package com.haojg.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 146477
 * @Date: 2018/8/9 15:46
 */
public class StringLambdaDemo {

    static void testLambda3(){
        String ids= "1,2,3,4,5,6";
        List<Long> listIds = Arrays.asList(ids.split(",")).stream()
                .filter(s->isNumber(s))
                .map(s ->Long.parseLong(s.trim()))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(listIds .toArray()));//[1,2,3,3,4,5,6]
    }
    static void testLambda2(){
        String ids= "1,2,a1,4w,5,6";
        List<String> listIds2 = Arrays.asList(ids.split(",")).stream()
                .filter(s->isNumber(s))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(listIds2.toArray()));//[1,2,3,3,4,5,6]
    }

    static boolean isNumber(String s){
        char sArr[] = s.toCharArray();
        for(char a : sArr){
            if(!Character.isDigit(a)){
                return false;
            }
        }
        return true;
    }

    static void testLambda1(){
        String[] arr = { "program", "creek", "is", "a", "java", "site" };
        Stream<String> stream = Stream.of(arr);
        stream.forEach(y->System.out.println(y));
    }

    public static void main(String[] args) {
        testLambda2();
        String s ="hello";
        System.out.println(s.split("").length);
    }
}
