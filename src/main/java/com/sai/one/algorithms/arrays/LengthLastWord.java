package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/9/16.
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthLastWord {
    public static void main(String[] args) {

        System.out.print(lengthOfLastWord("a "));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        return length;
    }

}
