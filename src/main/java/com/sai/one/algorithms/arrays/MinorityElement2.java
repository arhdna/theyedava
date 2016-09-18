package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shravan on 18/9/16.
 * http://www.programcreek.com/2014/07/leetcode-majority-element-ii-java/
 */
public class MinorityElement2 {
    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 7, 7,};
        System.out.print(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();


        for (int i : num) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);

            } else {
                map.put(i, 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= (num.length / 3) + 1) {
                res.add(entry.getKey());
            }
        }


        return res;
    }

}
