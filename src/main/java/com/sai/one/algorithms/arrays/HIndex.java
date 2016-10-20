package com.sai.one.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by shravan on 10/20/2016.
 * http://www.programcreek.com/2014/05/leetcode-h-index-java/
 */
public class HIndex {
    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        System.out.print(hIndex(arr));
    }

    public static int hIndex(int[] citations) {
        if(citations==null || citations.length==0)
            return 0;
        Arrays.sort(citations);
        int res = 0;

        for(int i=0;i<citations.length;i++){
            int min = Math.min(citations[i],citations.length-i);
            res = Math.max(res,min);
        }

        return res;
    }
}
