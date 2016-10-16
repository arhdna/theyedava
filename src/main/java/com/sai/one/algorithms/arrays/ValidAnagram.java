package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/16/2016.
 * http://www.programcreek.com/2014/05/leetcode-valid-anagram-java/
 */
public class ValidAnagram {

    public static void main(String[] args) {

        System.out.print(isAnagram("saishravan", "shravanasi"));
    }

    public static boolean isAnagram(String s, String t) {
        boolean res = true;
        if(s==null || t==null)
            return false;

        if (s.length() == t.length()) {
            int[] tmp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                tmp[s.charAt(i) - 'a']++;
                tmp[t.charAt(i) - 'a']--;
            }
            for (int val : tmp) {
                if (val != 0) {
                    res = false;
                    break;
                }
            }
        } else
            res = false;
        return res;
    }

}
