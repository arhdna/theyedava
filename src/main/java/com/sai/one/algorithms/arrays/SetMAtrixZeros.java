package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 9/11/16.
 * http://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
 */
public class SetMAtrixZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[0][4] = 0;

        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 0;

        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        matrix[2][3] = 1;
        matrix[2][4] = 1;

        matrix[3][0] = 1;
        matrix[3][1] = 0;
        matrix[3][2] = 1;
        matrix[3][3] = 1;
        matrix[3][4] = 1;

        matrix[4][0] = 1;
        matrix[4][1] = 1;
        matrix[4][2] = 1;
        matrix[4][3] = 1;
        matrix[4][4] = 1;



        setZeroes(matrix);
    }


    public static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for(int i=0; i<matrix.length;i++){
            if(matrix[i][0]==0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                firstRowZero = true;
                break;
            }
        }

        for(int i=1; i<matrix.length;i++){
            for(int j=1; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1; i<matrix.length;i++){
            for(int j=1; j<matrix[0].length;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        System.out.print("matrix"+matrix);
    }
}
