package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/16/2016.
 * http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
 */
public class ValidateBST {
    class BNode {
        TreeNode n;
        double left;
        double right;

        public BNode(TreeNode n, double left, double right) {
            this.n = n;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while (!queue.isEmpty()) {
            BNode b = queue.poll();
            if(b.n.value <= b.left || b.n.value >=b.right){
                return false;
            }

            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.value));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.value, b.right));
            }
        }
        return true;
    }

}
