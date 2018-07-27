package com.haojg.sort.quick;

import com.haojg.sort.quick.QuickSort;

public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T>
{
    @Override
    protected void sort(T[] nums, int l, int h)
    {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    public static void main(String[] args) {

        Integer v = 9;
        System.out.println(v.compareTo(8));

        Integer nums[]={5,5,2,1,3,9,8,7,9};
        for (Integer num : nums) {
            System.out.print(num +" , ");
        }
        System.out.println();

        new ThreeWayQuickSort().sort(nums, 0, nums.length-1);

        for (Integer num : nums) {
            System.out.print(num +" , ");
        }
    }
}