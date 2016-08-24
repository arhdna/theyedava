package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shravan on 24/8/16.
 * http://www.programcreek.com/2012/12/leetcode-3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 0, 2, 2};
        System.out.print(threeSum(arr, 0));
    }


    public static List<List<Integer>> threeSum(int[] numbers, int target) {
        Arrays.sort(numbers);

        List<List<Integer>> lsres = new ArrayList<List<Integer>>();
        for (int l = 0; l < numbers.length; l++) {
            if (l == 0 || numbers[l] > numbers[l - 1]) {
                int i = l + 1;
                int j = numbers.length - 1;
                while (i < j) {
                    int val = numbers[l] + numbers[i] + numbers[j];
                    if (val == target) {
                        List<Integer> num = new ArrayList<Integer>();
                        num.add(numbers[l]);
                        num.add(numbers[i]);
                        num.add(numbers[j]);
                        lsres.add(num);
                        i++;
                        j--;
                        while (i < j && numbers[i] == numbers[i - 1])
                            i++;
                        while (i < j && numbers[j] == numbers[j + 1])
                            j--;
                    } else if (val < target) {
                        i++;
                    } else if (val > target) {
                        j--;
                    }
                }
            }
        }
        return lsres;

    }

}
