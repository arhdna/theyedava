package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/19/2016.
 * http://www.programcreek.com/2013/02/leetcode-balanced-binary-tree-java/
 */
public class BalanceBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (getHeight(root) == -1)
            return false;

        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if ((Math.abs(left - right)) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

}
