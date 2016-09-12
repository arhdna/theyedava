package com.sai.one.algorithms.arrays;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 */
public class ContainDuplicates3 {
    public static void main(String[] args) {
        int[] nm = {-1, -1};
        System.out.print(containsDuplicate(nm, 1, -1));
    }


    public static boolean containsDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> st = new TreeSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            long vl = (long) nums[i];
            long left = vl - t;
            long right = vl + t;

            long tmp;
            if (left > right) {
                tmp = left;
                left = right;
                right = tmp;
            }
            Set<Long> srt = st.subSet(left, true, right, true);
            if (srt.size() > 0) {
                return true;
            }

            st.add(vl);

            if (i >= k) {
                st.remove((long) nums[i - k]);
            }

        }
        return false;
    }
}
