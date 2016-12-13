package com.sai.one.algorithms.arrays.linkedlist;

import java.util.LinkedList;

/**
 * Created by white on 12/13/2016.
 * http://www.programcreek.com/2014/06/leetcode-implement-stack-using-queues-java/
 */
public class ImplStack {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    LinkedList<Integer> queue1 = new LinkedList<Integer>();
    LinkedList<Integer> queue2 = new LinkedList<Integer>();

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.size() > 0) {
            queue1.poll();
        } else if (queue2.size() > 0) {
            queue2.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (queue1.size() > 0) {
            return queue1.peek();
        } else if (queue2.size() > 0) {
            return queue2.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() & queue2.isEmpty();
    }


    // Push element x onto stack.
    public void push(int x) {
        if (empty()) {
            queue1.offer(x);
        } else {
            if (queue1.size() > 0) {
                queue2.offer(x);
                while ((!queue1.isEmpty())){
                    queue2.offer(queue1.pop());
                }
            } else if(queue2.size()>0){
                queue1.offer(x);
                while ((!queue2.isEmpty())){
                    queue1.offer(queue2.pop());
                }
            }
        }
    }
}
