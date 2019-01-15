package com.haojg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * 求字符串最大不重复的长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0, j=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i-j+1);
        }

        return res;
    }

    public static int lengthOfLongestSubstring2(String s){
        if(s == null || s.length()==0) return 0;
        Set<Character> set = new HashSet<>();
        int res =0;
        for (int i=0,j=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
            }else{
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcdbcbb";
        int c = lengthOfLongestSubstring(s);
        System.out.println(c);

        int c2 = lengthOfLongestSubstring2(s);
        System.out.println(c2);

    }
}
