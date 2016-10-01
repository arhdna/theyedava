package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 27/9/16.
 * http://www.programcreek.com/2014/04/leetcode-pascals-triangle-ii-java/
 */
public class PascalTriangle2 {
    public static void main(String[] args) {
        System.out.print(generate(3));
    }

    public static List<Integer> generate(int numRows) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 0; i < numRows; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}
