package com.haojg.sort2;

/**
 * @Author: 146477
 * @Date: 2018/8/20 11:10
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j = j - h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
