package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-maximum-depth-of-binary-tree-java/
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger+1;
    }
}
