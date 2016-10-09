package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/9/2016.
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.print(shortestPalindrome("aaecaaa"));
    }

    public static String shortestPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }

        if (i == s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + suffix;
    }

}
