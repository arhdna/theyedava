package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/14/2016.
 * http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
 */
public class isPalindrome {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode p = head;
        ListNode prev = new ListNode(head.val);
        while (p.next != null) {
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while (p1 != null) {
            if (p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
