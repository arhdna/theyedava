package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 20/9/16.
 */
public class LargestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"sad", "sadasdasd"};
        System.out.print(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        int minLen = strs.length + 1;

        int sub = 0;
        String res = "";
        for (String wrd : strs) {
            minLen = Math.min(minLen, wrd.length());
        }

        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                String s1 = strs[j];
                String s2 = strs[j + 1];
                if (s1.charAt(i) != s2.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        res = strs[0].substring(0, minLen);
        return res;
    }
}
