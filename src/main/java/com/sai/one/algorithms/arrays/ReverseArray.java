package com.sai.one.algorithms.arrays;

import java.util.Scanner;

/**
 * Created by shravan
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        reverseArr(arr);
    }


    public static void reverseArr(int arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int aSize = arr.length - 1; aSize >= 0; aSize--) {
            sb.append(arr[aSize] + " ");
        }
        System.out.print(sb.toString());
    }
}

