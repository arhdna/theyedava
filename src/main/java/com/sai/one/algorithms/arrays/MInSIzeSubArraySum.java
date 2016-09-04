package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 4/9/16.
 * http://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/
 */
public class MInSIzeSubArraySum {
    public static void main(String[] args) {
        int s = 11;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.print(subarraylen(nums, s));
    }

    public static int subarraylen(int[] nums, int s) {
        int sum = 0;
        int minlen = nums.length;
        int start = 0;
        int i = 0;
        boolean exists = false;
        while (i <= nums.length) {
            if (sum >= s) {
                exists = true;

                minlen = Math.min(minlen, i - start);
                sum = sum - nums[start];
                start++;

            } else {
                if (i == nums.length)
                    break;
                sum = sum + nums[i];
                i++;
            }
        }

        if (exists) {

            return minlen;
        }

        return 0;
    }


}
