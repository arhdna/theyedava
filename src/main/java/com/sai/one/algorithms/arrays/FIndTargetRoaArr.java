package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 18/9/16.
 * http://www.programcreek.com/2014/06/leetcode-search-in-rotated-sorted-array-ii-java/
 */
public class FIndTargetRoaArr {
    public static void main(String[] args) {
        int[] nums = {14, 15, 16, 17, 10, 10, 11, 11, 12, 14, 14};
        System.out.print(search(nums, 10));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1) {
            return nums[0] == target;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            } else if (nums[left] > nums[mid]) {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }

        }
        return false;
    }
}
