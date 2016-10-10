package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 10/10/2016.
 * http://www.programcreek.com/2014/07/leetcode-summary-ranges-java/
 */
public class SummaryRange {

    public static void main(String[] args) {
        int[] arr = {5, 16};
        System.out.print(summaryRanges(arr));
    }


    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        if (nums == null || nums.length == 0)
            return result;

        if (nums.length == 1) {
            result.add(nums[0] + "");
        }

        int tmp = nums[0] - 1;
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (++tmp == nums[i]) {
                System.out.print("---");
            } else {
                if(pre == nums[i - 1])
                    result.add(pre+"");
                else
                    result.add(pre + "->" + nums[i - 1]);
                pre = nums[i];
                tmp = nums[i];
            }
        }

        if(pre == nums[nums.length-1])
            result.add(pre+"");
        else
            result.add(pre + "->" + nums[nums.length-1]);


        return result;
    }

}
