package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 21/8/16.
 */
public class InsertInterval {

    public static void main(String args[]) {
        InsertInterval i = new InsertInterval();
        List<InsertInterval.Interval> intervals = new ArrayList<InsertInterval.Interval>();
        intervals.add(i.new Interval(1, 2));
        intervals.add(i.new Interval(3, 5));
        intervals.add(i.new Interval(6, 7));
        intervals.add(i.new Interval(8, 10));
        intervals.add(i.new Interval(12, 16));
        System.out.print(merge(intervals, i.new Interval(4, 9)).toString());
    }

    public static List<InsertInterval.Interval> merge(List<InsertInterval.Interval> intervals, Interval newInterval) {
        List<InsertInterval.Interval> reslist = new ArrayList<InsertInterval.Interval>();
        if (intervals.size() <= 0) return reslist;
        InsertInterval m = new InsertInterval();


        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                reslist.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                reslist.add(newInterval);
                newInterval = intervals.get(i);
            } else if (newInterval.start <= intervals.get(i).end || newInterval.end >= intervals.get(i).start) {
                InsertInterval.Interval merge = m.new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
                newInterval = merge;
            }

        }
        reslist.add(newInterval);
        return reslist;
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

        @Override
        public String toString() {
            return "[" + start +
                    "," + end +
                    ']';
        }
    }
}
