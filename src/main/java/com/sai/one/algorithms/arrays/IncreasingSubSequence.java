package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/10/2016.
 * http://www.programcreek.com/2015/02/leetcode-increasing-triplet-subsequence-java/
 */
public class IncreasingSubSequence {

    public static void main(String[] args) {
        int[] arr = {5, 2, 16, 30, 50};
        System.out.print(increasingTriplet(arr));
    }

    public static boolean increasingTriplet(int[] nums) {
        boolean res = false;

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];
            if (x >= z) {
                x = z;
            } else if (y >= z) {
                y = z;
            } else
                return true;
        }
        return res;
    }

}
