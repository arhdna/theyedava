package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/20/2016.
 * http://www.programcreek.com/2014/03/leetcode-symmetric-tree-java/
 */
public class IsSymmetryBT {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }

        if (l.value != r.value)
            return false;

        if (!isSymmetric(l.left, r.right))
            return false;
        if (!isSymmetric(l.right, r.left))
            return false;

        return true;
    }
}
