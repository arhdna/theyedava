package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/
 */
public class MatrixMinPathSum {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 6;
        matrix[1][1] = 7;
        matrix[1][2] = 8;

        matrix[2][0] = 11;
        matrix[2][1] = 12;
        matrix[2][2] = 13;

        System.out.print(minPathSum(matrix));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // initialize top row
        for(int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        // initialize left col
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        // fill up the dp table
        for(int i=1; i<m; i++) {
            for (int j = 1; j < n; j++) {
                if(dp[i-1][j]>dp[i][j-1]){
                    dp[i][j] = grid[i][j]+dp[i][j-1];
                }else{
                    dp[i][j] = grid[i][j]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
