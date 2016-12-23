package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 12/22/2016.
 * http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-ii-java/
 */
public class UniqueBSTPopulation {

    public static void main(String args[]){
        generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    public static List<TreeNode> helper(int m, int n){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(m>n){
            result.add(null);
            return result;
        }

        for(int i=m; i<=n; i++){
            List<TreeNode> ls = helper(m, i-1);
            List<TreeNode> rs = helper(i+1, n);
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode curr = new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }

        return result;
    }
}
