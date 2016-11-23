package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 11/22/2016.
 * http://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/
 */
public class MatrixValidSudoko {
    public static void main(String[] args) {
        char[][] matrix = new char[5][5];

        isValidSudoku(matrix);
        //System.out.print(1/9);
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    if(m[(int) board[i][j] - '1']){
                        return false;
                    }
                    m[(int) board[i][j] - '1'] = true;
                }
            }
        }

        // check each rows
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if(board[i][j]!='.'){
                    if(m[(int) board[i][j] - '1']){
                        return false;
                    }
                    m[(int) board[i][j] - '1'] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block/3*3; i < block/3*3+3; i++) {
                for (int j = block%3*3; block < block%3*3+3; block++) {
                    if(board[i][j]!='.'){
                        if(m[(int) board[i][j] - '1']){
                            return false;
                        }
                        m[(int) board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
