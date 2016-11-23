package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/22/2016.
 * http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
 */
public class MatrixRotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[0][4] = 5;

        matrix[1][0] = 6;
        matrix[1][1] = 7;
        matrix[1][2] = 8;
        matrix[1][3] = 9;
        matrix[1][4] = 10;

        matrix[2][0] = 11;
        matrix[2][1] = 12;
        matrix[2][2] = 13;
        matrix[2][3] = 14;
        matrix[2][4] = 15;

        matrix[3][0] = 16;
        matrix[3][1] = 17;
        matrix[3][2] = 18;
        matrix[3][3] = 19;
        matrix[3][4] = 20;

        matrix[4][0] = 21;
        matrix[4][1] = 22;
        matrix[4][2] = 23;
        matrix[4][3] = 24;
        matrix[4][4] = 25;

        rotate(matrix);
        System.out.print("s");
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] =  matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] =  matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}
