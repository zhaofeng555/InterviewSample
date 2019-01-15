package com.haojg.leetcode;

import com.haojg.Printer;

import java.util.HashMap;
import java.util.Map;

public class TowSum {

    /**
     * 数组的两个元素求和
     *  1. tow sum
     * given nums = [2, 7, 11, 15], target = 9
     *
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] towSum(int[]nums, int target){
        int[] res =new int[]{-1, -1};
        if(nums == null || nums.length<2){
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={2, 7, 11, 15};
        int target = 9;
        int rs[]=towSum(nums, target);
        Printer.print(rs);
    }

}
