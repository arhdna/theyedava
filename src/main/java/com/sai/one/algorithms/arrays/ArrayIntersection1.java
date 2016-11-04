package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by shravan on 2/11/16.
 */
public class ArrayIntersection1 {

    public static void main(String[] args) {
        int[] arr = {3,7,1,4,9,2};
        int[] arr2 = {3,5,6,9,1,2};
        System.out.print(intersect(arr, arr2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<Integer>();
        for(int nu:nums1){
            map.add(nu);
        }

        ArrayList<Integer> ar = new ArrayList<>();

        for(int nu:nums2){
            if(map.contains(nu)){
                ar.add(nu);
            }
        }

        int[] result = new int[ar.size()];
        int i=0;
        for(int n: ar){
            result[i++] = n;
        }

        return result;
    }
}
