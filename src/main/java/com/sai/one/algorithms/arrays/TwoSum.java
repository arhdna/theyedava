package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 23/8/16.
 * http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 0};
        System.out.print(twoSum(arr, 0));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ar = new int[2];
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i <= numbers.length / 2; i++) {

            if (numbers[i] + numbers[numbers.length - i - 1] == target) {
                ar[0] = i;
                ar[1] = numbers.length - i - 1;
                break;
            }

            if (mp.containsKey(numbers[i])) {
                ar[0] = mp.get(numbers[i]);
                ar[1] = i;
                break;
            } else if (mp.containsKey(numbers[numbers.length - i - 1])) {
                ar[1] = mp.get(numbers[numbers.length - i - 1]);
                ar[0] = numbers.length - i - 1;
                break;
            } else {
                mp.put(target - numbers[i], i);
                mp.put(target - numbers[numbers.length - i - 1], numbers.length - i - 1);
            }
        }
        return ar;
    }
}
