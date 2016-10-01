package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 29/9/16.
 * http://www.programcreek.com/2014/06/leetcode-trapping-rain-water-java/
 */
public class TappingRainWater {
    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 4, 1};
        System.out.print(trap(arr1));
    }

    public static int trap(int[] height) {
        int result = 0;

        if (height == null || height.length <= 2)
            return result;

        int left[] = new int[height.length];
        int right[] = new int[height.length];

        int max = 0;
        left[0] = height[0];
        max = height[0];
        //scan left to right
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                left[i] = max;
            } else {
                left[i] = max;
            }
        }

        right[height.length - 1] = height[height.length - 1];
        max = height[height.length - 1];
        //scan left to right
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
                right[i] = max;
            } else {
                right[i] = max;
            }
        }

        for (int i = 0; i < height.length; i++) {
            result = result + Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

}
