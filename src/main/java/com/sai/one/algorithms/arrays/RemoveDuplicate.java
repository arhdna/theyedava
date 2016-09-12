package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int size = countUnique(arr);
        System.out.println(size);
    }

    public static int countUnique(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
