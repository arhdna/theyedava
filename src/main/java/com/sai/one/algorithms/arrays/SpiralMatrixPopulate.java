package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/11/16.
 * http://www.programcreek.com/2014/05/leetcode-spiral-matrix-ii-java/
 */
public class SpiralMatrixPopulate {


    public static void main(String[] args) {
        System.out.print(generateMatrix(5));
    }


    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int k = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (k <= n * n) {
            for (int i = left; i <= right; i++) {
                result[top][i] = k;
                k++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = k;
                k++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                result[bottom][i] = k;
                k++;
            }
            bottom--;


            for (int i = bottom; i >= top; i--) {
                result[i][left] = k;
                k++;
            }
            left++;

        }
        return result;
    }
}
