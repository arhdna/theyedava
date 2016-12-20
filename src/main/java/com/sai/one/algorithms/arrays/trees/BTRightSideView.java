package com.sai.one.algorithms.arrays.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by white on 12/20/2016.
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/
 */
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            //get size here
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if (i == 0) {
                    result.add(top.value);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                //add left
                if (top.left != null) {
                    queue.add(top.left);
                }
            }
        }
        return result;
    }
}
