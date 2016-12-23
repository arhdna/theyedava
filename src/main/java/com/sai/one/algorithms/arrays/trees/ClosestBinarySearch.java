package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-closest-binary-search-tree-value-java/
 */
public class ClosestBinarySearch {

    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int result = root.value;

        while (root != null) {
            if (target > root.value) {

                double diff = Math.abs(root.value - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.value;
                }
                root = root.right;
            } else if (target < root.value) {
                double diff = Math.abs(root.value - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.value;
                }
                root = root.left;
            } else {
                return root.value;
            }
        }
        return result;
    }
}
