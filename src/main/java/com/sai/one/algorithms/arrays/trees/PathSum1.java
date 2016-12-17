package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/17/2016.
 * http://www.programcreek.com/2013/01/leetcode-path-sum/
 */
public class PathSum1 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.value);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if (curr.left == null && curr.right == null && sumValue == sum)
                return true;

            if (curr.left != null) {
                nodes.offer(curr.left);
                values.offer(sumValue + curr.left.value);
            }

            if (curr.right != null) {
                nodes.offer(curr.right);
                values.offer(sumValue + curr.right.value);
            }

        }
        return false;
    }
}
