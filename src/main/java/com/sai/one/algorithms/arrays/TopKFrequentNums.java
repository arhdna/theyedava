package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan on 10/16/2016.
 * http://www.programcreek.com/2014/05/leetcode-top-k-frequent-elements-java/
 */
public class TopKFrequentNums {


    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 1, 1, 1, 1};
        System.out.print(topKFrequent(arr, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        class Pair {
            int num;
            int count;

            public Pair(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.count - o2.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while (pq.size() > 0) {
            result.add(pq.poll().num);
        }
        //reverse the order
        Collections.reverse(result);
        return result;
    }
}
