package com.haojg.expression2;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestAviator {
    private String aa="jack";

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public static void main(String[] args) {
        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(20);
        list.add(10);
        env.put("list", list);
        env.put("email", "haojg@gmail.com");
        env.put("test", new TestAviator());
        env.put("date",new Date());
        String username = (String) AviatorEvaluator.execute("email=~/([\\w0-8]+)@\\w+[\\.\\w+]+/ ? $1 : 'unknow' ", env);
        System.out.println(username);
        System.out.println(AviatorEvaluator.exec("a>0? 'yes':'no'", 1));
        System.out.println(AviatorEvaluator.execute("'test.aa ='+test.aa", env));
        System.out.println(AviatorEvaluator.execute(" obj==nil", env));
        System.out.println(AviatorEvaluator.execute(" date > '2018-05-21 00:00:00:00'", env));
        System.out.println(AviatorEvaluator.execute(" date > '2018-05-22 12:00:00:00'", env));

        Object result = AviatorEvaluator.execute("count(list)", env);
        System.out.println(result);  // 3
        result = AviatorEvaluator.execute("reduce(list,+,0)", env);
        System.out.println(result);  // 33
        result = AviatorEvaluator.execute("filter(list,seq.gt(9))", env);
        System.out.println(result);  // [10, 20]
        result = AviatorEvaluator.execute("include(list,10)", env);
        System.out.println(result);  // true
        result = AviatorEvaluator.execute("sort(list)", env);
        System.out.println(result);  // [3, 10, 20]
        System.out.println(AviatorEvaluator.execute("map(list,println)", env));;

        System.out.println(AviatorEvaluator.execute("string.length('hello')"));    // 求字符串长度
        System.out.println(AviatorEvaluator.execute("string.contains('hello','h')"));  //判断字符串是否包含字符串
        System.out.println(AviatorEvaluator.execute("string.startsWith('hello','h')"));  //是否以子串开头
        System.out.println(AviatorEvaluator.execute("string.endsWith('hello','llo')"));  //是否以子串结尾

        System.out.println(AviatorEvaluator.execute("math.pow(-3,2)"));   // 求n次方
        System.out.println(AviatorEvaluator.execute("math.sqrt(14.0)"));   //开平方根
        System.out.println(AviatorEvaluator.execute("math.sin(20)"));    //正弦函数
    }
}