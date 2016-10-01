package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 27/9/16.
 * http://www.programcreek.com/2014/03/leetcode-pascals-triangle-java/
 */
public class PascalTriangle1 {

    public static void main(String[] args) {
        System.out.print(generate(1));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);

        for (int i = 0; i < numRows - 1; i++) {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            ar.add(1);
            for (int j = 0; j < result.get(i).size() - 1; j++) {
                ar.add(result.get(i).get(j) + result.get(i).get(j + 1));
            }
            ar.add(1);
            result.add(ar);
        }

        return result;
    }


}
