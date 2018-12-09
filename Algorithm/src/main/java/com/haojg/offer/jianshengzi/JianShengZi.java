package com.haojg.offer.jianshengzi;

/**
 * @Author: 146477
 * @Date: 2018/7/27 16:40
 */
public class JianShengZi {

    public static void main(String[] args) {
        int n = 11;
        int sum = integerBreak(n);
        System.out.println(sum);
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(6));
        System.out.println(integerBreak(7));
        System.out.println(integerBreak(8));
        System.out.println(integerBreak(9));
    }

    public static int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
                System.out.println("j = " + j + " , value=" + dp[j]);
                System.out.println("i = " + i + " , value=" + dp[i]);
            }
            System.out.println("----------------------");
        }
        return dp[n];
    }
}
