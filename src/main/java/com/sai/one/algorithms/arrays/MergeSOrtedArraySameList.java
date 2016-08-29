package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 27/8/16.
 */
public class MergeSOrtedArraySameList {


    public static void main(String[] args) {
        int[] one = {5, 8, 0, 0, 0};
        int[] two = {1, 2, 7};
        System.out.print(merge(one, 2, two, 3));
    }


    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[n + m - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0) {

            nums1[n + m - 1] = nums2[n - 1];
            n--;
        }
        return nums1;
    }
}
