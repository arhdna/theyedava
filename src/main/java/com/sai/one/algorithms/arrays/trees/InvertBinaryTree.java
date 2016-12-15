package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/15/2016.
 * http://www.programcreek.com/2014/06/leetcode-invert-binary-tree-java/
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);

            TreeNode tmp = p.left;
            p.left = p.right;
            p.right = tmp;
        }
        return root;
    }

}
