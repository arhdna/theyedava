package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 17/9/16.
 * http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-java/
 */
public class FindMInRoatedArr {
    public static void main(String[] args) {
        int[] nums = {14, 15, 16, 17, 10, 11, 12};
        System.out.print(search(nums, 10));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

        }
        return -1;
    }

}
