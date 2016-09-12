package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/
 */
public class RemoveDulplicates2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int size = countUnique(arr);
        System.out.println(size);
    }

    public static int countUnique(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length <= 2)
            return nums.length;
        int i = 1;

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i] || (nums[j] == nums[i] && nums[j] != nums[i - 1])) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
