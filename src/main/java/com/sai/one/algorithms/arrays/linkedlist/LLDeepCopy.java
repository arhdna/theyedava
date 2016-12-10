package com.sai.one.algorithms.arrays.linkedlist;

import java.util.HashMap;

/**
 * Created by white on 12/10/2016.
 * http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
 */
public class LLDeepCopy {

    static class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;

        RandomListNode(int x) {
            val = x;
            next = null;
            random = null;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.val);

        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);

        p = p.next;
        while(p!=null){
            RandomListNode copy = new RandomListNode(p.val);
            map.put(p,copy);
            q.next = copy;
        }

        p = head;
        q = newHead;
        while(p!=null){
           if(p.random!=null){
                q.random = map.get(p.random);
           }
        }

        return q;
    }
}
