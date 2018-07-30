package com.haojg.offer.numberof1;

/**
 * @Author: 146477
 * @Date: 2018/7/27 17:20
 */
public class NumberOf1N {
    public static void main(String[] args) {
        int c = NumberOf1(7);
        System.out.println(c);
    }

    public static int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
//            n &= (n - 1);

            n = n & (n-1);
        }
        return cnt;
    }
}
