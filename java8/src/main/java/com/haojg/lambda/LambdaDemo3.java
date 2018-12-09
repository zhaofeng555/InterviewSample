package com.haojg.lambda;

@FunctionalInterface
interface Interface3 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}

public class LambdaDemo3 {

    public static void main(String[] args) {
        Interface3 i1 = (i) -> i * 2;
        System.out.println(i1.doubleNum(3));

        Interface3 i2 = i -> i * 2;

        Interface3 i3 = (int i) -> i * 2;

        Interface3 i4 = (int i) -> {
            System.out.println(i);
            return i * 2;
        };
        System.out.println(i4.doubleNum(5));
        System.out.println(i4.add(10, 20));
    }

}