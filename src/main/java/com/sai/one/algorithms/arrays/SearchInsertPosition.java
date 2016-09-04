package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 4/9/16.
 * http://www.programcreek.com/2013/01/leetcode-search-insert-position/
 */
public class SearchInsertPosition {


    public static void main(String[] args) {
        int s = 3;
        int[] nums = {1, 2, 4, 5};

        System.out.print(searchInsert(nums, s));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null)
            return -1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m;
            } else {
                return m;
            }
        }
        return j;
    }

}
