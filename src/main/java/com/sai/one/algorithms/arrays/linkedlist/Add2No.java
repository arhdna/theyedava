package com.sai.one.algorithms.arrays.linkedlist;

import java.util.LinkedList;

/**
 * Created by white on 12/9/2016.
 * http://www.programcreek.com/2012/12/add-two-numbers/
 */
public class Add2No {

    public static void main(String[] args) {

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.offer(1);
        l1.offer(2);
        l1.offer(3);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.offer(4);
        l2.offer(5);
        System.out.print(addTwoNumbers(l1,l2));
    }

        public static LinkedList addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
            int carry = 0;

            LinkedList<Integer> newHead = new LinkedList<>();
            LinkedList<Integer> p1 = l1, p2 = l2, p3 = newHead;

            while (p1.peek()!=null || p2.peek() != null) {
                if (p1.peek() != null) {
                    carry = carry+p1.poll();
                }
                if (p2.peek() != null) {
                    carry = carry+p2.poll();
                }

                p3.offer(carry%10);
                carry = carry/10;
            }

            if(carry==1)
                p3.offer(1);
            return p3;
        }


}
