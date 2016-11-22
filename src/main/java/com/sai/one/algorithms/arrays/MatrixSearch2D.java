package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/13/2016.
 * http://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/
 */
public class MatrixSearch2D {

    public static void main(String[] args) {
        int[][] matrix = new int[5][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        //matrix[0][4] = 5;

        matrix[1][0] = 6;
        matrix[1][1] = 7;
        matrix[1][2] = 8;
        matrix[1][3] = 9;
        // matrix[1][4] = 10;

        matrix[2][0] = 11;
        matrix[2][1] = 12;
        matrix[2][2] = 13;
        matrix[2][3] = 14;
        //matrix[2][4] = 15;

        matrix[3][0] = 16;
        matrix[3][1] = 17;
        matrix[3][2] = 18;
        matrix[3][3] = 19;
        //matrix[3][4] = 20;

        matrix[4][0] = 21;
        matrix[4][1] = 22;
        matrix[4][2] = 23;
        matrix[4][3] = 24;
        // matrix[4][4] = 25;

        System.out.print(searchMatrix(matrix,3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start<end){
            int md = (start+end)/2;
            int r = md/n;
            int c = md%n;

            if(matrix[r][c]==target)
                return true;

            if(matrix[r][c]>target){
                end = md-1;
            }else{
                start = md+1;
            }
        }

        return false;
    }
}
