package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 27/8/16.
 * http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 */
public class StringToInteger {

    public static void main(String[] args) {

        System.out.print(atoi("2147483648"));
    }

    public static int atoi(String str) {
        double res = 0;
        str = str.trim();
        int i = 0;
        if (str.length() == 0) return (int) res;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            i++;
        }
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i)))
                res = (res * 10) + (str.charAt(i) - '0');
            else
                break;
            i++;
        }
        if (str.charAt(0) == '-')
            res = -res;

        if (res < Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE)
            res = Integer.MAX_VALUE;
        return (int) res;

    }

}
