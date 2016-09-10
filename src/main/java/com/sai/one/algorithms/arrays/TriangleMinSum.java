package com.sai.one.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by shravan on 10/9/16.
 * http://www.programcreek.com/2013/01/leetcode-triangle-java/
 */
public class TriangleMinSum {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<ArrayList<Integer>>();
        finalArr.add(new ArrayList<Integer>());
        finalArr.add(new ArrayList<Integer>());
        finalArr.add(new ArrayList<Integer>());
        //finalArr.add(new ArrayList<Integer>());

        finalArr.get(0).add(-1);
        finalArr.get(1).add(2);
        finalArr.get(1).add(3);
        finalArr.get(2).add(1);
        finalArr.get(2).add(-1);
        finalArr.get(2).add(-3);

        System.out.print(minimumTotal(finalArr));
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int first = triangle.get(0).get(0);

        for (int x = 1; x < triangle.size(); x++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < triangle.get(x).size(); i++) {
                min = Math.min(min, (first + triangle.get(x).get(i)));
            }
            first = min;
        }

        return first;
    }
}
