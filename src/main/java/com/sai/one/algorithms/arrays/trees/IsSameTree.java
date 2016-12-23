package com.sai.one.algorithms.arrays.trees;

/**
 * Created by white on 12/23/2016.
 * http://www.programcreek.com/2012/12/check-if-two-trees-are-same-or-not/
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }

        if(p.value==q.value){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
}
