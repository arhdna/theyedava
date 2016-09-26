package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 26/9/16.
 * http://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/
 */
public class ComapreVersions {

    public static void main(String[] args) {

        System.out.print(compareVersion("11.2", "11"));
        System.out.print(compareVersion("01", "1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        while (i < arr1.length || i < arr2.length) {
            if (i < arr1.length && i < arr2.length) {
                if (Integer.valueOf(arr1[i]) > Integer.valueOf(arr2[i])) {
                    return 1;
                }
                if (Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i])) {
                    return -1;
                }
            } else if (i < arr1.length) {
                if (Integer.valueOf(arr1[i]) != 0) {
                    return 1;
                }
            } else if (i < arr2.length) {
                if (Integer.valueOf(arr2[i]) != 0) {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }


}
