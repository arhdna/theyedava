package com.sai.one.algorithms.arrays.linkedlist;


/**
 * Created by white on 12/10/2016.
 * http://www.programcreek.com/2012/12/leetcode-linked-list-cycle/
 */
public class LLCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
