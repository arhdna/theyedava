package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 10/10/2016.
 * http://www.programcreek.com/2016/04/get-target-using-number-list-and-arithmetic-operations-google/
 */
public class TargetNumList {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.print(isReachable(arr,21));
    }

    public static boolean isReachable(ArrayList<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return false;


        return false;
    }
}
