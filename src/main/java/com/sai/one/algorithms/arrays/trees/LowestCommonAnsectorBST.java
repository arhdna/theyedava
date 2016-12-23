package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/21/2016.
 * http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-search-tree-java/
 */
public class LowestCommonAnsectorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode m = root;

        if (m.value > p.value && m.value < q.value) {
            return m;
        } else if (m.value > p.value && m.value > q.value) {
            return lowestCommonAncestor(m.left, p, q);
        } else if (m.value < p.value && m.value < q.value) {
            return lowestCommonAncestor(m.right, p, q);
        }
        return root;
    }
}
