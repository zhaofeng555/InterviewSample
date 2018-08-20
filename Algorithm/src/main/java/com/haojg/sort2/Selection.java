package com.haojg.sort2;

/**
 * @Author: 146477
 * @Date: 2018/8/20 10:02
 */
public class Selection<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for(int j=i+1;j<N; j++){
                if(less(nums[j], nums[min])){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}
