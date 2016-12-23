package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/22/2016.
 * http://www.programcreek.com/2014/05/leetcode-populating-next-right-pointers-in-each-node-java/
 */
public class PopulateNxtPointer {
    class TreeLinkNode {

        int value;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;

        public TreeLinkNode(int value) {
            this.value = value;
        }

    }

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();

        if (root != null) {
            nodeQueue.offer(root);
            depthQueue.offer(1);
        }

        while (!nodeQueue.isEmpty()) {
            TreeLinkNode topNode = nodeQueue.poll();
            int depth = depthQueue.poll();
            if (depthQueue.isEmpty()) {
                topNode.next = null;
            } else if (depthQueue.peek() > depth) {
                topNode.next = null;
            } else {
                topNode.next = nodeQueue.peek();
            }

            if (topNode.left != null) {
                nodeQueue.offer(topNode.left);
                depthQueue.offer(depth + 1);
            }

            if (topNode.right != null) {
                nodeQueue.offer(topNode.right);
                depthQueue.offer(depth + 1);
            }
        }
    }
}
