package com.sai.one.algorithms.arrays;

import java.util.PriorityQueue;

/**
 * Created by shravan on 18/8/16.
 * http://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
 */
public class KLargestArray {

    public static  void main(String args[]){
        int[] arr = {1,4,5,22,7,88,9};
        System.out.print(findKthLargest(arr,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int val:nums){
            pq.offer(val);
            if(nums.length-k+1==pq.size()){
                return val;

            }
        }
        return -1;
    }
}
