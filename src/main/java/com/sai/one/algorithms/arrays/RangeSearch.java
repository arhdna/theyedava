package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 1/10/16.
 * http://www.programcreek.com/2014/04/leetcode-search-for-a-range-java/
 */
public class RangeSearch {

    public static void main(String[] args) {
        int[] arr1 = {8};
        System.out.print(searchRange(arr1, 8));
    }


    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;

        int i = 0;
        int j = nums.length;

        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else if (nums[m] > target) {
                j = m;
            } else {
                int tmp = m;
                while (tmp >= 0 && nums[tmp] == target) {
                    tmp--;
                }
                arr[0] = tmp + 1;
                tmp = m;
                while (tmp < nums.length && nums[tmp] == target) {
                    tmp++;
                }
                arr[1] = tmp - 1;
                return arr;
            }
        }

        return arr;
    }


}
