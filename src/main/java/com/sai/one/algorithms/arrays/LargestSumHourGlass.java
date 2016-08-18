package com.sai.one.algorithms.arrays;

import java.util.Scanner;

/**
 * Created by shravan
 */
public class LargestSumHourGlass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        findLargestSum(arr);
    }

    public static void findLargestSum(int arr[][]) {
        int hourVal = Integer.MIN_VALUE;
        for (int x = 0; x <= 6 / 2; x++) {
            for (int y = 0; y <= 6 / 2; y++) {
                int xx = x + 2;

                int tempVal = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1]
                        + arr[xx][y] + arr[xx][y + 1] + arr[xx][y + 2];
                if (hourVal < tempVal) {
                    hourVal = tempVal;
                }
            }
        }
        System.out.print(hourVal);
    }
}
