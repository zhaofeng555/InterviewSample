package com.haojg.offer.array;

public class FindTwoSum {

    public static int[] towSum(int[]numbers, int target){
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            int sum = numbers[i]+numbers[j];
            if(sum == target){
                return new int[]{i+1, j+1};
            }else if (sum < target){
                i ++;
            }else{
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[]numbers={2,7,11,15};
        int target = 9;
        int rs[]=towSum(numbers, target);
        System.out.println(rs);
    }

}
