package com.haojg.offer.array;

public class MaxNumArrayTest {
    public static int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int num[] = {6, -3, -2, 7, -15, 1, 2, 2};
        int i = FindGreatestSumOfSubArray(num);
        System.out.println(i);

    }
}
