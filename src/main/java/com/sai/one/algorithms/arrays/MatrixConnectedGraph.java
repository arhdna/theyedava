package com.sai.one.algorithms.arrays;

/**
 * Created by white on 12/7/2016.
 * http://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
 */
public class MatrixConnectedGraph {


    public static void main(String args[]) {
        int[][] grid = null;
        countComponents(5, grid);
    }


    public static int countComponents(int n, int[][] edges) {
        int count = n;

        int[] root = new int[n];
        // initialize each node is an island
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            int xRoot = getRoot(root, x);
            int yRoot = getRoot(root, y);

            if (xRoot != yRoot) {
                count--;
                root[xRoot] = yRoot;
            }
        }

        return count;
    }

    public static int getRoot(int[] arr, int i) {
        while (arr[i] != i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

}
