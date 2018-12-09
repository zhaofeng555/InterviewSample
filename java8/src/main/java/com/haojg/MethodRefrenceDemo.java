package com.haojg;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

class Dog {
    String name = "犬";
    int food = 10;

    static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MethodRefrenceDemo {

    public static void main(String[] args) {

        //方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("输入数据");

        //静态方法的引用
        Consumer<Dog> comsumer2 = Dog::bark;
        Dog dog = new Dog();
        comsumer2.accept(dog);

//		Function<Integer, Integer> function = dog::eat;
        UnaryOperator<Integer> function = dog::eat;
        System.out.println("还剩" + function.apply(2) + "斤");

        IntUnaryOperator function2 = dog::eat;
        System.out.println("还剩" + function2.applyAsInt(2) + "斤");

        BiFunction<Dog, Integer, Integer> eatFunc = Dog::eat;
        System.out.println("还剩下" + eatFunc.apply(dog, 2) + "斤");

    }

}