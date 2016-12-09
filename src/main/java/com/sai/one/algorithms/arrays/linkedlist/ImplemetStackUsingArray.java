package com.sai.one.algorithms.arrays.linkedlist;

/**
 * Created by white on 12/8/2016.
 * http://www.programcreek.com/2015/03/implement-a-stack-using-an-array/
 */
public class ImplemetStackUsingArray {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>(11);
        stack.push("hello");
        stack.push("world");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

    static class Stack<E> {
        private E[] arr = null;
        private int CAP;
        private int top = -1;
        private int size = 0;

        @SuppressWarnings("unchecked")
        public Stack(int cap) {
            this.CAP = cap;
            this.arr = (E[]) new Object[cap];
        }

        public E pop() {
            if(size==0){
                return null;
            }
            size--;
            E e = arr[top];
            arr[top] = null;
            top--;
            return e;
        }

        public boolean push(E e) {
            if(size==CAP){
                return false;
            }

            arr[++top] = e;
            size++;
            return true;
        }

        public String toString() {
            if(this.size==0){
                return null;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<this.size; i++){
                sb.append(this.arr[i] + ", ");
            }

            sb.setLength(sb.length()-2);
            return sb.toString();
        }
    }
}
