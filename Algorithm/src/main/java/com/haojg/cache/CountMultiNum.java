package com.haojg.cache;

import java.util.Scanner;

/**
 * @Author: 146477
 * @Date: 2018/6/29 17:02
 */
public class CountMultiNum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 4, 3, 3, 3, 3, 5, 9};
        Integer num = null;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (cnt == 0) {
                num = x;
            }
            System.out.println("当前 num = " + num);
            if (num == x) {
                cnt++;
            } else {
                cnt--;
            }
            System.out.println("次数 cnt = " + cnt);
        }
        System.out.println("halfMultiData = " + num);
    }
}
