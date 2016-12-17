package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/16/2016.
 * http://www.programcreek.com/2014/04/leetcode-binary-tree-longest-consecutive-sequence-java/
 */
public class LongestConsective {

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        LinkedList<Integer> sizeQueue = new LinkedList<Integer>();

        nodeQueue.offer(root);
        sizeQueue.offer(1);
        int max = 1;

        while (!nodeQueue.isEmpty()) {
            TreeNode head = nodeQueue.poll();
            int size = sizeQueue.poll();

            if(head.left!=null){
                int leftsize = size;
                if(head.value == head.left.value-1){
                    leftsize++;
                    max= Math.max(max,leftsize);
                }else{
                    leftsize = 1;
                }
                nodeQueue.offer(head.left);
                sizeQueue.offer(leftsize);
            }

            if(head.right!=null){
                int rightSize=size;
                if(head.value==head.right.value-1){
                    rightSize++;
                    max = Math.max(max, rightSize);
                }else{
                    rightSize=1;
                }

                nodeQueue.offer(head.right);
                sizeQueue.offer(rightSize);
            }

        }

        return max;
    }
}
