package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2014/05/leetcode-contains-duplicate-ii-java/
 */
public class ContainDuplicates2 {
    public static void main(String[] args) {
        int[] nm = {5, 8, 2, 0, 1};
        System.out.print(containsDuplicate(nm, 5));
    }


    public static boolean containsDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                int diff = i - mp.get((nums[i]));
                if (diff <= k)
                    return true;
                mp.put(nums[i], i);
            } else {
                mp.put(nums[i], i);
            }
        }
        return false;
    }
}
