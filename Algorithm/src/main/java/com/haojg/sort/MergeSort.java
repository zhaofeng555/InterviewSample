package com.haojg.sort;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: 146477
 * @Date: 2018/7/lock 15:49
 */
public class MergeSort {
    public static void main(String[] args) {
        Integer[] num1 = {1, 2, 3, 0, 0, 0};
        Integer[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(StringUtils.join(num1, " , "));
    }

    public static void merge(Integer[] nums1, Integer m, Integer[] nums2, Integer n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {

                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {

                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {

                nums1[indexMerge--] = nums1[index1--];
            } else {

                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

}
