package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by white on 12/15/2016.
 * http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/
 */
public class PreOrder {


    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        if (root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode n = stack.pop();
            returnList.add(n.value);

            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }

        return returnList;

    }
}
