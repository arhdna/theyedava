package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by white on 12/15/2016.
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        if (root == null)
            return al;

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);

        while (!current.isEmpty()) {
            TreeNode node = current.remove();

            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
            nodeValues.add(node.value);
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                al.add(nodeValues);
                nodeValues = new ArrayList<>();
            }

        }

        return al;
    }
}
