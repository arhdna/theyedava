package com.sai.one.algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shravan on 4/9/16.
 * http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
 */
public class LongestConsectiveSequence {

    public static void main(String[] args) {
        int s = 3;
        int[] nums = {1, 2, 4, 5, 6};

        System.out.print(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        int max = 0;

        Set<Integer> s = new HashSet<Integer>();
        for (int e : num) {
            s.add(e);
        }

        for (int e : num) {
            if (s.isEmpty()) break;
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (s.contains(left)) {
                s.remove(left);
                left--;
                count++;
            }

            while (s.contains(right)) {
                s.remove(right);
                right++;
                count++;
            }

            max = Math.max(count, max);
        }
        return max;
    }

}
