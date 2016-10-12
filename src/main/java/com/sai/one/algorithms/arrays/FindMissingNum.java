package com.sai.one.algorithms.arrays;

import java.util.Arrays;

/**
 * Created by shravan on 10/12/2016.
 * http://www.programcreek.com/2014/05/leetcode-missing-number-java/
 */
public class FindMissingNum {
    public static void main(String[] args) {
        int[] arr = {0,1,3,4,5,6};
        System.out.print(missingNumber(arr));
    }

    //works only whenstarted with 0
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int n:nums){
            sum+=n;
        }
        int t = (nums.length*(nums.length+1))/2;
        return t-sum;
    }

    public static int missingNumbers(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l+r)/2;
            if(nums[m]>m){
                r=m;
            }else{
                l=m+1;
            }
        }
        return r;
    }
}
