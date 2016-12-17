package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 12/17/2016.
 * http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/
 */
public class PathSumAll {

    public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(root.value);
        dfs(root, sum - root.value, result, l);
        return result;
    }

    public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l) {
        if (t.left == null && t.right == null && sum == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(l);
            result.add(temp);
        }

        if (t.left != null) {
            l.add(t.left.value);
            dfs(t.left, sum - t.left.value, result, l);
            l.remove(l.size() - 1);
        }

        if (t.right != null) {
            l.add(t.right.value);
            dfs(t.right, sum - t.right.value, result, l);
            l.remove(l.size() - 1);
        }
    }
}
