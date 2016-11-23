package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/
 */
public class MatrixUniquePath2 {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 0;
        matrix[0][1] = 0;
        matrix[0][2] = 0;

        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = 0;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 0;

        System.out.print(uniquePathsWithObstacles(matrix));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
            return 0;


        int[][] dp = new int[m][n];
        dp[0][0]=1;

        //left column
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0] = 0;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        //top row
        for(int i=1; i<m; i++){
            if(obstacleGrid[0][i]==1){
                dp[0][i] = 0;
            }else{
                dp[0][i] = dp[0][i-1];
            }
        }


        // fill up the dp table
        for(int i=1; i<m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}