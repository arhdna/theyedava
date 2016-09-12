package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2014/04/leetcode-remove-element-java/
 */
public class RemoveGIvenElement {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int size = removeElement(arr, 1);
        System.out.println(size);
    }

    public static int removeElement(int[] nums, int removeElement) {


        int i = -1;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != removeElement) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
