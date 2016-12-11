package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/11/2016.
 * http://www.programcreek.com/2015/03/leetcode-odd-even-linked-list-java/
 */
public class OddEvenList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;

        ListNode result = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;
        while (p1 != null && p2 != null) {
            if (p2.next == null) break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;
        return result;
    }

}
