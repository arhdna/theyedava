package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shravan on 24/8/16.
 * http://www.programcreek.com/2013/02/leetcode-4sum-java/
 */
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.print(FourSum(arr, -1));
    }


    public static List<List<Integer>> FourSum(int[] numbers, int target) {
        Arrays.sort(numbers);

        List<List<Integer>> lsres = new ArrayList<List<Integer>>();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) continue;
            for (int j = i + 1; j < numbers.length; j++) {
                if (j == i + 1 || numbers[j] > numbers[j - 1]) {
                    int k = j + 1;
                    int l = numbers.length - 1;
                    while (k < l) {
                        int val = numbers[l] + numbers[i] + numbers[j] + numbers[k];
                        if (val == target) {
                            List<Integer> num = new ArrayList<Integer>();
                            num.add(numbers[i]);
                            num.add(numbers[j]);
                            num.add(numbers[k]);
                            num.add(numbers[l]);
                            lsres.add(num);
                            k++;
                            l--;
                            while (k < l && numbers[k] == numbers[k - 1])
                                k++;
                            while (k < l && numbers[l] == numbers[l + 1])
                                l--;
                        } else if (val < target) {
                            k++;
                        } else if (val > target) {
                            l--;
                        }
                    }
                }
            }
        }
        return lsres;

    }
}
