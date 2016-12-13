package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/13/2016.
 * http://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/
 */
public class RemoveNthElement {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //if remove the first node
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}
