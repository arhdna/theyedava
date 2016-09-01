package com.sai.one.algorithms.arrays;

import java.util.Stack;

/**
 * Created by shravan on 30/8/16.
 * http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
 */
public class LongestValidParanthesis {
    public static void main(String[] args) {
        System.out.print(isValid("()()(()))"));
    }

    public static int isValid(String s) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                int len = 0;
                int tmp = st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int tmp2 = st.peek();
                    len = i - tmp2;
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}
