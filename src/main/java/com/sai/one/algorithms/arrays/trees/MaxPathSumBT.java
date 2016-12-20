package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/19/2016.
 * http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
 */
public class MaxPathSumBT {
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.value, Math.max(root.value + left, root.value + right));
        max[0] = Math.max(max[0], Math.max(current, root.value + left + right));
        return current;
    }
}
