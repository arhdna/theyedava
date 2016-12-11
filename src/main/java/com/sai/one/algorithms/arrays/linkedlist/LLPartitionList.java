package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/11/2016.
 * http://www.programcreek.com/2013/02/leetcode-partition-list-java/
 */
public class LLPartitionList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while (p != null) {
            if(p.val<x){
                p=p.next;
                prev = prev.next;
            }else{
                p2.next = p;
                prev.next = p.next;
                p = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        prev.next = fakeHead2.next;
        return fakeHead1.next;
    }
}
