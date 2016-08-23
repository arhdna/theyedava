package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 23/8/16.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSorted {

    public static void main(String[] args) {
        int[] arr = {-3, 3, 4, 90};
        System.out.print(twoSum(arr, 0));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ar = new int[2];
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        int i = 0;
        int j = search(numbers, target, 0, numbers.length - 1);
        if (numbers[j] < 0) j = numbers.length - 1;
        while (i <= j) {
            if (numbers[i] + numbers[j] == target) {
                ar[0] = i + 1;
                ar[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }

        return ar;
    }

    public static int search(int[] numbers, int target, int start, int end) {
        int middle = ((start + end) / 2);
        if (start > end)
            return -1;

        if (numbers[middle] == target) {
            return middle;
        } else if (numbers[middle - 1 < 0 ? middle : middle - 1] < target && numbers[middle] > target && numbers[middle + 1 >= numbers.length ? middle : middle + 1] > target) {
            return middle - 1;
        } else if (numbers[middle - 1 < 0 ? middle : middle - 1] < target && numbers[middle] < target && numbers[middle + 1 >= numbers.length ? middle : middle + 1] > target) {
            return middle;
        } else if (middle + 1 >= numbers.length && numbers[middle - 1 < 0 ? middle : middle - 1] < target && numbers[middle] < target && numbers[middle + 1 >= numbers.length ? middle : middle + 1] < target) {
            return middle;
        } else if (numbers[middle] > target) {
            end = middle - 1;
        } else if (numbers[middle] < target) {
            start = middle + 1;
        }

        return search(numbers, target, start, end);
    }
}
