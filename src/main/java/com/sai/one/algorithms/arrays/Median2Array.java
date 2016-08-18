package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 14/8/16.
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 */
public class Median2Array {

    public static void main(String args[]) {
        int[] one = {4, 5, 6};
        int[] two = {7,8, 9};
        System.out.print(findMedianSortedArraysOptimized(one, two));
    }

    private static double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {


        if ((nums1.length + nums2.length) %2 == 0) {
            double one =  findMediaRecersive(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length + nums2.length)/2);
            double two =        findMediaRecersive(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, ((nums1.length + nums2.length)/2)-1)  ;
            return (one+two)/2;
        }else{
            return findMediaRecersive(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1, (nums1.length + nums2.length)/2);
        }

    }

    private static double findMediaRecersive(int[] nums1, int[] nums2, int aStart, int aEnd, int bStart,  int bEnd, int median) {

        int al = aEnd-aStart+1;
        int bl = bEnd-bStart+1;

        if(al == 0){
            return  nums2[bStart+median];
        }

        if(bl == 0){
            return  nums1[aStart+median];
        }

        if(median == 0){
            return  nums1[aStart]< nums2[bStart]?nums1[aStart]:nums2[bStart];
        }


        int am = (median*al)/(al+bl);
        int bm = median-am-1;
        am = am+aStart;
        bm  = bm+bStart;


        if (nums1[am] <= nums2[bm]) {
           median = median - (am - aStart + 1);
            bEnd = bm;
            aStart = am +1;
        } else  {
            median = median - (bm - bStart + 1);
            aEnd = am;
            bStart = bm +1;
        }
        return findMediaRecersive(nums1, nums2, aStart, aEnd, bStart, bEnd, median);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int evenodd = (nums1.length + nums2.length) % 2;
        int median = (nums1.length + nums2.length) / 2;
        int i = 0, j = 0, k = 0;
        double value = 0l;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                nums3[k++] = nums2[j++];
            } else {
                nums3[k++] = nums1[i++];
            }

            if (median + 1 == k) {
                if (evenodd == 0) {
                    return value = (double) (nums3[median - 1] + nums3[median]) / 2;
                } else {
                    return value = nums3[median];
                }
            }
        }

        while (i < nums1.length) {
            nums3[k++] = nums1[i++];
            if (median + 1 == k) {
                if (evenodd == 0) {
                    return value = (double) (nums3[median - 1] + nums3[median]) / 2;
                } else {
                    return value = nums3[median];
                }
            }
        }
        while (j < nums2.length) {
            nums3[k++] = nums2[j++];
            if (median + 1 == k) {
                if (evenodd == 0) {
                    return value = (double) (nums3[median - 1] + nums3[median]) / 2;
                } else {
                    return value = nums3[median];
                }
            }
        }
        return value;
    }
}
