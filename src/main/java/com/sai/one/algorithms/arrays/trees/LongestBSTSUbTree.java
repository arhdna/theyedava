package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2014/07/leetcode-largest-bst-subtree-java/
 */
public class LongestBSTSUbTree {
    class Wrapper{
        int size;
        int lower, upper;
        boolean isBST;

        public Wrapper(){
            lower = Integer.MAX_VALUE;
            upper = Integer.MIN_VALUE;
            isBST = false;
            size = 0;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }

    public Wrapper helper(TreeNode node){
        Wrapper curr = new Wrapper();

        if(node == null){
            curr.isBST= true;
            return curr;
        }

        Wrapper l = helper(node.left);
        Wrapper r = helper(node.right);

        //current subtree's boundaries
        curr.lower = Math.min(node.value, l.lower);
        curr.upper = Math.max(node.value, r.upper);

        //check left and right subtrees are BST or not
        //check left's upper again current's value and right's lower against current's value
        if(l.isBST && r.isBST && l.upper<=node.value && r.lower>=node.value){
            curr.size = l.size+r.size+1;
            curr.isBST = true;
        }else{
            curr.size = Math.max(l.size, r.size);
            curr.isBST  = false;
        }

        return curr;
    }

}
