package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/21/2016.
 * http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/
 */
public class LowestCommonAnsestorBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        } else if (l == null && r == null) {
            return null;
        } else {
            return l == null ? r : l;
        }
    }

}
