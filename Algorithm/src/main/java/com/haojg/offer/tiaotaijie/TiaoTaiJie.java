package com.haojg.offer.tiaotaijie;

/**
 * @Author: 146477
 * @Date: 2018/7/31 16:50
 */
public class TiaoTaiJie {
    public static int jumpFloor1(int n){
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    public static int jumpFloor2(int n){
        if(n <= 2){
            return n;
        }
        int pre2=1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int c1 = jumpFloor1(n);
        int c2 = jumpFloor2(n);
        System.out.println(c1);
        System.out.println(c2);

    }
}
