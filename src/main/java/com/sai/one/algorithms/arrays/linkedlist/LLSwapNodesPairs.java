package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/12/2016.
 * http://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/
 */
public class LLSwapNodesPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //a fake head
        ListNode h = new ListNode(0);
        h.next = head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode pre = h;
        while (p1 != null && p2 != null) {
            pre.next=p2;
            ListNode t = p2.next;
            p2.next = p1;
            p1.next = t;
            pre=p1;
            p1=p1.next;
            if(t!=null){
                p2 = t.next;
            }
        }
        return h.next;
    }

    public static void main(String args[]){
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        swapPairs(ls);
    }
}
