package com.sai.one.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by shravan on 30/10/16.
 * http://www.programcreek.com/2014/05/leetcode-scramble-string-java/
 */
public class ScrambleString {
    public static void main(String[] args) {
        System.out.print(isScramble("great", "rgeat"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        if (s1.length() == 0 || s1.equals(s2))
            return true;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!new String(arr1).equals(new String(arr2))) {
            return false;
        }

        for(int i=1; i<s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            String s23 = s2.substring(0, s2.length() - i);
            String s24 = s2.substring(s2.length() - i, s2.length());

            if (isScramble(s11, s21) && isScramble(s12, s22))
                return true;

            if(isScramble(s11, s24) && isScramble(s12, s23))
                return true;
        }

        return false;
    }
}
