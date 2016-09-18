package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 17/9/16.
 * http://www.programcreek.com/2014/03/leetcode-find-minimum-in-rotated-sorted-array-ii-java/
 */
public class FindMinRotatedArrDUplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1};
        System.out.print(findMin(nums));
    }


    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = 0;
        if (nums == null || nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];
        while (left <= right) {


            while (nums[left] == nums[right] && left != right) {
                left++;
            }

            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = (left + right) / 2;

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
