package com.sai.one.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2014/05/leetcode-contains-duplicate-java/
 */
public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nm = {5, 8, 2, 0, 1, 1};
        System.out.print(containsDuplicate(nm));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> ss = new HashSet<Integer>();
        for (int nm : nums) {
            if (!ss.add(nm)) {
                return true;
            }
        }
        return false;
    }
}
