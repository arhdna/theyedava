package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/06/leetcode-count-complete-tree-nodes-java/
 */
public class CompleteTreeNodeCount {

    public int getLeftHeight(TreeNode n) {
        if (n == null) return 0;

        int height = 0;
        while (n.left != null) {
            height++;
            n = n.left;
        }
        return height;
    }

    public int getRightHeight(TreeNode n) {
        if (n == null) return 0;

        int height = 0;
        while (n.right != null) {
            height++;
            n = n.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = getLeftHeight(root) + 1;
        int right = getRightHeight(root) + 1;

        if (left == right) {
            return (2 << (left - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
