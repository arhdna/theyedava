package com.sai.one.algorithms.arrays;

import java.util.Stack;

/**
 * Created by shravan on 18/9/16.
 * http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
 */
public class HistogramLargestRect {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 6};
        System.out.print(largestRectangleArea(nums));
    }

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int max = 0;
        while (i < height.length) {
            if (st.isEmpty() || height[st.peek()] <= height[i]) {
                st.push(i);
                i++;
            } else {
                int top = st.pop();
                int w = st.isEmpty() ? i : (i - st.peek() - 1);
                max = Math.max(max, height[top] * w);
            }
        }

        while (!st.isEmpty()) {
            int top = st.pop();
            int w = st.isEmpty() ? i : (i - st.peek() - 1);
            max = Math.max(max, height[top] * w);
        }

        return max;
    }
}
