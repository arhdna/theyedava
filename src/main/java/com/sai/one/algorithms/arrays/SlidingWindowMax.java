package com.sai.one.algorithms.arrays;

import java.util.LinkedList;

/**
 * Created by shravan on 2/11/16.
 * http://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
 */
public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 7, 3, 9, 1};
        System.out.print(maxSlidingWindow(arr, 2));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            if (!ll.isEmpty() && ll.peekFirst() == i - k)
                ll.poll();

            while (!ll.isEmpty() && nums[ll.peekLast()] < nums[i]) {
                ll.removeLast();
            }

            ll.offer(i);

            if (i + 1 >= k) {
                result[i + 1 - k] = nums[ll.peek()];
            }
        }

        return result;
    }
}
