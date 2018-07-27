package com.haojg.threesum;

/**
 * @Author: 146477
 * @Date: 2018/7/26 11:03
 */
public class ThreeSumSlow implements ThreeSum {

    //n*(n-1)*(n-2)
    @Override
    public int count(int[] nums) {
        int N = nums.length;
        int cnt = 0;
        for(int i=0;i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k = j+1; k<N; k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }
}
