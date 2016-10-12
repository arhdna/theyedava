package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/12/2016.
 * http://www.programcreek.com/2015/06/leetcode-find-the-duplicate-number-java/
 */
public class FindMissingDupicate {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 2, 8, 1};
        System.out.print(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            int c = 0;
            for (int i : nums) {
                if (i <= m) {
                    c++;
                }
            }
            //if c < m,
            if (c > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

}
