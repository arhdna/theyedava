package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 8/10/16.
 * http://www.programcreek.com/2014/05/leetcode-basic-calculator-ii-java/
 */
public class BasicCalculator2 {
    public static void main(String[] args) {

        System.out.print(calculate("1-1"));
    }


    public static int calculate(String s) {

        int res = 0;
        int pre = 0;
        int sign = 1;
        int md = -1;

        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = ch - '0';
                while (i++ < s.length() - 1 && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                i--;
                if (md == 0) {
                    pre = pre * num;
                    md = -1;
                } else if (md == 1) {
                    pre = pre / num;
                    md = -1;
                } else {
                    pre = num;
                }
            } else if (ch == '*') {
                md = 0;
            } else if (ch == '/') {
                md = 1;
            } else if (ch == '+') {
                res = res + pre * sign;
                sign = 1;
            } else if (ch == '-') {
                res = res + pre * sign;
                sign = -1;
            }
        }
        res = res + sign * pre;
        return res;
    }
}
