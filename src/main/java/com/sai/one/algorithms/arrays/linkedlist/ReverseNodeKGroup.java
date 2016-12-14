package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/14/2016.
 * http://www.programcreek.com/2014/05/leetcode-reverse-nodes-in-k-group-java/
 */
public class ReverseNodeKGroup {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }
        }
        return fake.next;
    }

    /*
 * 0->1->2->3->4->5->6
 * |           |
 * pre        next
 *
 * after calling pre = reverse(pre, next)
 *
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next
 */
    public ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        return last;
    }

}
