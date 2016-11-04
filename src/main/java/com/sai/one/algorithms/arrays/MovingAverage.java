package com.sai.one.algorithms.arrays;

import java.util.LinkedList;

/**
 * Created by shravan on 4/11/16.
 * http://www.programcreek.com/2014/05/leetcode-moving-average-from-data-stream-java/
 */
public class MovingAverage {
    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 7, 3, 9, 1};
        System.out.print(movingAverage(arr, 3));
    }

    public static int[] movingAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int sum = 0;
        int j = 0;

        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            ll.offer(nums[i]);
            sum = sum + nums[i];
            if (ll.size() >= k) {
                result[j++] = sum / k;
                sum = sum - ll.poll();
            }
        }

        return result;
    }
}
