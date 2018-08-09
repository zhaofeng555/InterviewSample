package com.haojg.offer.duplicate;

import com.haojg.Util;
import org.apache.commons.lang3.StringUtils;

public class DuplicateNum {

    public static boolean duplicate(Integer []nums, int length, int []duplication){
        if(nums == null|| length<=0){
            return false;
        }
        System.out.println(StringUtils.join(nums, ","));

        for (int i = 0; i < length; i++) {
            while (nums[i]!=i){
//                System.out.println(StringUtils.join(nums, "-"));
                if(nums[i] == nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                Util.swap(nums, i, nums[i]);
            }
        }
        System.out.println(StringUtils.join(nums, "-"));
        return false;
    }

    public static void main(String[] args) {
        Integer nums[]={2,3,1,0,2,5};
        int length=nums.length;
        int duplication[]=new int[1];
        boolean flag = duplicate(nums, length, duplication);
        System.out.println(flag);
    }
}
