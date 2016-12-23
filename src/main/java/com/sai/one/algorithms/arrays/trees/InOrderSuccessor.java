package com.sai.one.algorithms.arrays.trees;

import java.util.Stack;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-inorder-successor-in-bst-java/
 */
public class InOrderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null || p==null)
            return null;

        stack.push(root);
        boolean isNext = false;
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();

            if(top.right==null&&top.left==null){
                if(isNext){
                    return top;
                }

                if(p.value==top.value){
                    isNext = true;
                }
                continue;
            }

            if(top.right!=null){
                stack.push(top.right);
                top.right=null;
            }

            stack.push(top);

            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }
        }

        return null;
    }
}
