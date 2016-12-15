package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by white on 12/15/2016.
 * http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
 */
public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }else
            {
                result.add(top.value);
                stack.pop();
                if(top.right!=null)
                    stack.push(top.right);
            }
        }

        return result;
    }
}
