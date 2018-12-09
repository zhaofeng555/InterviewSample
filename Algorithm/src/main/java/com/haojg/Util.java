package com.haojg;

public class Util {
    public static void swap(Integer nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
