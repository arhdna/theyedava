package com.sai.one.algorithms.arrays.trees;

import java.util.LinkedList;

/**
 * Created by white on 12/21/2016.
 * http://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
 */
public class VerifyPreOrderBT {

    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] arr = preorder.split(",");

        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);

            while (stack.size() >= 3
                    && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#")
                    && !stack.get(stack.size() - 3).equals("#")) {

                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);

                stack.add("#");
            }

        }
        if (stack.size() == 1 && stack.get(0).equals("#"))
            return true;
        else
            return false;
    }
}
