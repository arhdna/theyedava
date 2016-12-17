package com.sai.one.algorithms.arrays.trees;

import java.util.Stack;

/**
 * Created by white on 12/16/2016.
 * http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
 */
public class FlattenBT {
    public class Solution {
        public void flatten(TreeNode root) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode p = root;

            while (p != null || !stack.empty()) {

                if(p.right!=null)stack.push(p.right);

                if(p.left!=null){
                    p.right = p.left;
                    p.left = null;
                }else if(!stack.isEmpty()){
                    p.right =  stack.pop();
                }
                p=p.right;
            }
        }
    }
}
