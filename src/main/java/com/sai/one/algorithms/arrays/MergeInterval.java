package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan on 21/8/16.
 * http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 */
public class MergeInterval {

    public static void main(String args[]) {
        MergeInterval i = new MergeInterval();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i.new Interval(1, 4));
        intervals.add(i.new Interval(0, 4));
        System.out.print(merge2(intervals).toString());
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        List<Interval> reslist = new ArrayList<Interval>();
        if (intervals.size() <= 0) return reslist;
        Map<Integer, Interval> bucket = new TreeMap<Integer, Interval>();


        for (Interval e : intervals) {
            if (bucket.get(e.start) != null) {
                Interval mid = bucket.get(e.start);
                e.end = Math.max(e.end, mid.end);
                bucket.put(e.start, e);
            } else {
                bucket.put(e.start, e);
            }
        }

        MergeInterval m = new MergeInterval();
        Interval pre = bucket.entrySet().iterator().next().getValue();
        for (Map.Entry<Integer, Interval> entry : bucket.entrySet()) {
            if (entry.getValue().start > pre.end) {
                reslist.add(pre);
                pre = entry.getValue();
            } else {
                Interval merge = m.new Interval(pre.start, Math.max(entry.getValue().end, pre.end));
                pre = merge;
            }
        }
        reslist.add(pre);
        return reslist;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> reslist = new ArrayList<Interval>();
        if (intervals.size() <= 0) return reslist;
        MergeInterval m = new MergeInterval();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });


        Interval pre = intervals.get(0);
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > pre.end) {
                reslist.add(pre);
                pre = intervals.get(i);
            } else {
                Interval merge = m.new Interval(pre.start, Math.max(intervals.get(i).end, pre.end));
                pre = merge;
            }

        }
        reslist.add(pre);
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
