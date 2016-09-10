package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/9/16.
 * http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class ZIgZagString {

    public static void main(String[] args) {

        System.out.print(convert("a", 2));
    }

    public static String convert(String s, int numRows) {

        if (numRows <= 1 || s.length() <= 1) return s;
        int step = 2 * numRows - 2;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            if (i == 0 || i == numRows - 1) {
                for (int ii = i; ii < s.length(); ii = ii + step) {
                    b.append(s.charAt(ii));
                }
            } else {
                int tmp = i;
                int step2 = 2 * (numRows - 1 - i);
                int step3 = step - step2;
                boolean step_flag = true;
                while (tmp < s.length()) {
                    b.append(s.charAt(tmp));
                    if (step_flag) {
                        tmp = tmp + step2;
                    } else {
                        tmp = tmp + step3;
                    }
                    step_flag = !step_flag;
                }
            }
        }
        return b.toString();
    }

}
