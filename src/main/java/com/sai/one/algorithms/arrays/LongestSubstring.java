package com.sai.one.algorithms.arrays;

import java.util.HashSet;

/**
 * Created by shravan on 12/9/16.
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 * http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("geekforgeeks"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        HashSet<Character> hs = new HashSet<Character>();
        while (i < s.length() && j < s.length()) {
            if (hs.contains(s.charAt(j))) {
                hs.remove(s.charAt(i));
                i++;
            } else {
                hs.add(s.charAt(j));
                ans = Math.max(ans, j - i);
                j++;
            }
        }
        return ans + 1;
    }
}
