package com.sai.one.algorithms.arrays;

/**
 * Created by white on 12/8/2016.
 * http://www.programcreek.com/2014/04/leetcode-range-sum-query-2d-immutable-java/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Immutable2DSumRangeQuery.java
 */
public class MatrixRangeSumQuery {
    private int[][] T;

    public void Immutable2DSumRangeQuery(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        T = new int[row + 1][col + 1];
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1] + matrix[i - 1][j - 1] - T[i - 1][j - 1];
            }
        }
    }

    public int sumQuery(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return T[row2][col2] - T[row1 - 1][col2] - T[row2][col1 - 1] + T[row1 - 1][col1 - 1];
    }

}
