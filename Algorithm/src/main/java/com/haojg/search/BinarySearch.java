package com.haojg.search;

/**
 * @Author: 146477
 * @Date: 2018/7/lock 16:57
 */
public class BinarySearch {

    public static int search(Integer[] nums, Integer target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (target.equals(nums[m])) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer num[] = {1, 3, 5, 7, 9};
        Integer rs = search(num, 3);
        System.out.println(rs);
    }
}
