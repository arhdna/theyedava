package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 2/11/16.
 */
public class ArrayIntersection2 {


    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 4, 9, 2};
        int[] arr2 = {3, 5, 6, 9, 1, 2};
        System.out.print(intersect(arr, arr2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int nu : nums1) {
            if (map.containsKey(nu)) {
                map.put(nu, map.get(nu) + 1);
            } else {
                map.put(nu, 1);
            }

        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int nu : nums2) {
            if (map.containsKey(nu)) {
                if(map.get(nu)>1){
                    map.put(nu,map.get(nu)-1);
                }else{
                    map.remove(nu);
                }
                list.add(nu);
            }
        }

        int[] result = new int[list.size()];
        int i =0;
        while(i<list.size()){
            result[i]=list.get(i);
            i++;
        }

        return result;
    }


}
