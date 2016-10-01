package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 27/9/16.
 * http://www.programcreek.com/2014/03/leetcode-gas-station-java/
 */
public class GasStation {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};
        System.out.print(canCompleteCircuit(arr1, arr2));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int remaingSum = 0;

        for (int i = 0; i < gas.length; i++) {
            int rem = gas[i] - cost[i];
            if (remaingSum >= 0) {
                remaingSum = remaingSum + rem;
            } else {
                start = i;
                remaingSum = rem;
            }
            total = total + rem;
        }
        return total >= 0 ? start : -1;
    }
}
