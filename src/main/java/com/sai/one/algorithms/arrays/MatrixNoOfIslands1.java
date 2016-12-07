package com.sai.one.algorithms.arrays;

/**
 * Created by white on 12/7/2016.
 * http://www.programcreek.com/2014/04/leetcode-number-of-islands-java/
 */
public class MatrixNoOfIslands1 {
    public static void main(String args[]) {
        char[][] grid = null;
        numIslands(grid);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[] root = new int[m * n];

        int count = 0;
        //if 1 set the index in root
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    root[i * n + j] = i * n + j;
                    count++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                            int cRoot = getRoot(root, i * n + j);
                            int nRoot = getRoot(root, x * n + y);
                            if (cRoot != nRoot) {
                                root[cRoot] = nRoot;
                                count--;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int getRoot(int[] arr, int i) {
        while (arr[i] != i) {
            i = arr[arr[i]];
        }

        return i;
    }
}
