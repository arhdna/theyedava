package com.sai.one.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by shravan on 25/8/16.
 * http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
 */
public class ThreeSumCloset {
    public static void main(String[] args) {
        int[] arr = {1, 1, -1, -1, 3};
        System.out.print(threeSum(arr, -1));
    }


    public static int threeSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int pre = Integer.MAX_VALUE - 1;
        for (int l = 0; l < numbers.length; l++) {
            if (l == 0 || numbers[l] > numbers[l - 1]) {
                int i = l + 1;
                int j = numbers.length - 1;
                while (i < j) {
                    int val = numbers[l] + numbers[i] + numbers[j];
                    int diff = Math.abs(target - val);
                    if (diff == 0) return val;
                    if (diff < Math.abs(target - pre)) {
                        pre = val;
                    } else if (val < target) {
                        i++;
                    } else if (val > target) {
                        j--;
                    }
                }
            }
        }
        return pre;
    }

}
