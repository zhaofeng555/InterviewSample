package com.haojg.offer.revese;

public class HuiWebTest {
    public static boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s){
        int i=-1,j=s.length();

        return false;
        
    }
}
