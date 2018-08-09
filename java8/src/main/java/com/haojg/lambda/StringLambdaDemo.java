package com.haojg.lambda;

import java.util.stream.Stream;

/**
 * @Author: 146477
 * @Date: 2018/8/9 15:46
 */
public class StringLambdaDemo {
    void testLambda1(){
        String[] arr = { "program", "creek", "is", "a", "java", "site" };
        Stream<String> stream = Stream.of(arr);
        stream.forEach(x -> System.out.println(x));
    }
}
