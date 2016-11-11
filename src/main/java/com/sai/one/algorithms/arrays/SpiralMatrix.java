package com.sai.one.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by shravan on 10/11/16.
 * http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
 */
public class SpiralMatrix {

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

        spiralOrder(matrix);
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0) return result;

        int r = matrix.length;
        int c = matrix[0].length;

        int x=0;
        int y=0;

        while(r > 0 && c > 0){

            if(r==1){
                for(int i=0; i<c; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(c==1){
                for(int i=0; i<r; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //top
            for(int i=0;i<c-1;i++){
                result.add(matrix[x][y++]);
            }

            //right
            for(int i=0;i<r-1;i++){
                result.add(matrix[x++][y]);
            }

            //bottom
            for(int i=0;i<c-1;i++){
                result.add(matrix[x][y--]);
            }

            //left
            for(int i=0;i<r-1;i++){
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            r=r-2;
            c=c-2;
        }

        return result;

    }

}
