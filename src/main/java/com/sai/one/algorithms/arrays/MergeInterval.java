package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 21/8/16.
 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 */
public class MergeInterval {

    public static void main(String args[]) {
        MergeInterval i = new MergeInterval();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i.new Interval(1, 3));
        intervals.add(i.new Interval(2, 6));
        intervals.add(i.new Interval(8, 10));
        intervals.add(i.new Interval(15, 18));
        System.out.print(merge(intervals).toString());
    }

    public static List<Interval> merge(List<Interval> intervals) {

    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
