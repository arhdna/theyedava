package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/05/leetcode-recover-binary-search-tree-java/
 */
public class NodeSwapBSTRecovery {
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void inorder(TreeNode root){
        if(root==null)
            return;

        inorder(root.left);

        if(pre==null){
            pre=root;
        }else{
            if(root.value<pre.value){
                if(first==null){
                    first=pre;
                }

                second=root;
            }
            pre=root;
        }

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if(root==null)
            return;

        inorder(root);
        if(second!=null && first !=null){
            int val = second.value;
            second.value = first.value;
            first.value = val;
        }

    }
}
