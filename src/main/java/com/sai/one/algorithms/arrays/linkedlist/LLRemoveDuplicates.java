package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/11/2016.
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-list/
 */
public class LLRemoveDuplicates {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;

        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val==p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup)
                {
                    p.next=p.next.next;
                }

            }else{
                p=p.next;
            }
        }
        return t.next;
    }
}
