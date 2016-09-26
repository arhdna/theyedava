package com.sai.one.algorithms.arrays;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by shravan on 22/9/16.
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] strs = {3, 30, 34, 5, 9};
        System.out.print(largestNumber(strs));
    }

    public static String largestNumber(int[] strs) {
        StringBuilder res = new StringBuilder();
        SortedSet<String> ss = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int val : strs) {
            ss.add(String.valueOf(val));
        }

        //Collections.sort(ss);

        for (String val : ss) {
            res.append(val);
        }

        return res.toString();
    }


}
