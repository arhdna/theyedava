package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/12/2016.
 * http://www.programcreek.com/2014/04/leetcode-remove-linked-list-elements-java/
 */
public class RemoveLLElements {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;

        while (p.next != null) {
            if(p.next.val == val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return helper.next;
    }
}
