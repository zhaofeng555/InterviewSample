package com.haojg.sort2;

/**
 * @Author: 146477
 * @Date: 2018/8/20 10:37
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean hasSorted = false;
        for (int i = N - 1; i > 0 && !hasSorted; i--) {
            hasSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    hasSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }
}
