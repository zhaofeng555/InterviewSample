package com.haojg.offer.revese;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsString {
    private final static Set<Character> vowles = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    static String reverseVowels(String s){
        int i=0, j=s.length()-1;
        char[] result = new char[s.length()];
        while (i<=j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if(!vowles.contains(ci)){
                result[i++]=ci;
            }else  if(!vowles.contains(cj)){
                result[j--]=cj;
            }else{
                result[i++]=cj;
                result[j--]=ci;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String rs = reverseVowels(s);
        System.out.println(s);
        System.out.println(rs);
    }

}
