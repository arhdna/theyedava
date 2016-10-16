package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/16/2016.
 * http://www.programcreek.com/2014/02/leetcode-find-peak-element/
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.print(findPeakElement(arr));
    }

    public static int findPeakElement(int[] num) {

        int i = 0;
        int j = num.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;

            if (mid == num.length - 1) {
                break;
            } else if (mid - 1 >= 0 && mid + 1 <= num.length - 1 && num[mid] >= num[mid - 1] && num[mid] >= num[mid + 1]) {
                i = mid;
                break;
            } else if (mid - 1 >= 0) {
                if (num[mid - 1] > num[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
                ;
            } else if (mid + 1 <= num.length - 1) {
                if (num[mid + 1] > num[mid])
                    i = mid + 1;
                else
                    j = mid - 1;
            }

        }
        return i;
    }
}
