package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 30/10/16.
 * http://www.programcreek.com/2014/05/leetcode-one-edit-distance-java/
 */
public class OneEditDistance {
    public static void main(String[] args) {
        System.out.print(isOneEditDistance("shravan", "siravan"));
    }


    public static boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null)
            return false;

        int m = s.length();
        int n = t.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                if (count > 1)
                    return false;
                if(m<n){
                    j++;
                }else if(m>n){
                    i++;
                }else{
                    i++;
                    j++;
                }
            }
        }

        if (i < m || j < n) count++;
        if (count == 1) return true;
        return false;

    }
}
