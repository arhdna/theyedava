package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 4/9/16.
 * http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
 */
public class ValidPalindrome {


    public static void main(String[] args) {
        System.out.print(isPalindrome("Red rum, sirs, is murder"));
    }

    public static boolean isPalindrome(String s) {
        //s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public boolean isAlpha(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }

    public boolean isNum(char a) {
        return a >= '0' && a <= '9';
    }
}
