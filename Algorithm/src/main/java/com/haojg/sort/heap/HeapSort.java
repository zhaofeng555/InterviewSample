package com.haojg.sort.heap;

import com.haojg.sort.Sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        //构建
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }

        //排序
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
//        System.out.println(nums[i] + " , "+ nums[j] );
        return nums[i].compareTo(nums[j]) < 0;
    }
}