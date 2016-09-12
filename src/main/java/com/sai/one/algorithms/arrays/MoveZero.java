package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2014/05/leetcode-move-zeroes-java/
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 2, 0, 3};
        moveZeroes(arr);

    }

    public static void moveZeroes(int[] nums) {


        int i = -1;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                i++;
                nums[i] = nums[j];
            }
        }

        for (int j = i + 1; j < nums.length; j++) {

            nums[j] = 0;

        }
        System.out.print("");
    }
}
