package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/22/2016.
 * http://www.programcreek.com/2014/04/leetcode-search-a-2d-matrix-ii-java/
 */
public class MatrixSearch2D2 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 4;
        matrix[0][2] = 7;
        matrix[0][3] = 11;
        matrix[0][4] = 15;

        matrix[1][0] = 2;
        matrix[1][1] = 5;
        matrix[1][2] = 8;
        matrix[1][3] = 12;
        matrix[1][4] = 19;

        matrix[2][0] = 3;
        matrix[2][1] = 6;
        matrix[2][2] = 9;
        matrix[2][3] = 16;
        matrix[2][4] = 22;

        matrix[3][0] = 10;
        matrix[3][1] = 13;
        matrix[3][2] = 14;
        matrix[3][3] = 17;
        matrix[3][4] = 24;

        matrix[4][0] = 18;
        matrix[4][1] = 21;
        matrix[4][2] = 23;
        matrix[4][3] = 26;
        matrix[4][4] = 30;

        System.out.print(searchMatrix(matrix,5));
    }

    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int m=matrix.length-1;
        int n=matrix[0].length-1;

        int i=m;
        int j=0;

        while(i>0 && j<m){
            if(target>matrix[i][j]){
                j++;
            }else if(target<matrix[i][j]){
                i--;
            }else{
                return true;
            }
        }

    return false;
    }

}
