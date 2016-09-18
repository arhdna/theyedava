package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 18/9/16.
 * http://www.programcreek.com/2014/02/leetcode-majority-element-java/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 7, 7,};
        System.out.print(majorityElement(nums));
    }

    public static int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if (num.length == 1) return num[0];

        for (int i : num) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                if (map.get(i) >= (num.length / 2) + 1) return i;
            } else {
                map.put(i, 1);
            }

        }
        return 0;
    }

}
