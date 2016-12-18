package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/18/2016.
 * http://www.programcreek.com/2013/01/leetcode-convert-sorted-array-to-binary-search-tree-java/
 */
public class SortedArrToBT {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
}
