package com.sai.one.algorithms.arrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by shravan on 1/10/16.
 * http://www.programcreek.com/2014/06/leetcode-basic-calculator-java/
 */
public class BasicCalculator1 {

    public static void main(String[] args) {

        System.out.print(calculate("1"));
    }


    public static int calculate(String s) {
        // delete white spaces
        long res = 0;
        s = s.replaceAll(" ", "");
        if (s != null && s.length() > 0) {
//            s = postTrasform(s);
//            res = finalCalc(s);

            //new logic
            Queue<String> stack = new LinkedList<String>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    sb.append(ch);
                    if (i == s.length() - 1) {
                        stack.add(sb.toString());
                    }
                } else {
                    if (sb.length() > 0) {
                        stack.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    stack.add(String.valueOf(ch));
                }
            }
            if (stack.size() > 1) {
                stack = postTrasform(stack);
                res = finalCalc(stack);
            } else {
                res = Long.valueOf(stack.remove());
            }
        }
        return (int) res;
    }


    //this logic works only for single digits
    public static Queue<String> postTrasform(Queue<String> s) {
        Stack<String> st = new Stack<String>();
        Queue<String> sb = new LinkedList<String>();
        while (!s.isEmpty()) {
            String ch = s.remove();
            if (ch.equalsIgnoreCase("+") || ch.equalsIgnoreCase("-")) {
                gotOper(ch, 1, st, sb);
            } else if (ch.equalsIgnoreCase("*") || ch.equalsIgnoreCase("/")) {
                gotOper(ch, 2, st, sb);
            } else if (ch.equalsIgnoreCase("(")) {
                st.push(ch);
            } else if (ch.equalsIgnoreCase(")")) {
                gotParan(ch, st, sb);
            } else {
                sb.add(ch);
            }
        }
        while (!st.isEmpty()) {
            sb.add(st.pop());
        }

        return sb;
    }

    public static Long finalCalc(Queue<String> s) {
        Stack<Long> st = new Stack<Long>();
        while (!s.isEmpty()) {
            String ch = s.remove();
            if (!ch.equalsIgnoreCase("+") && !ch.equalsIgnoreCase("-") && !ch.equalsIgnoreCase("*") && !ch.equalsIgnoreCase("/")) {
                st.push(Long.valueOf(ch));
            } else {
                Long ch2 = st.pop();
                Long ch1 = st.pop();
                if (ch.equalsIgnoreCase("+")) {
                    st.push(ch1 + ch2);
                } else if (ch.equalsIgnoreCase("-")) {
                    st.push(ch1 - ch2);
                } else if (ch.equalsIgnoreCase("*")) {
                    st.push(ch1 * ch2);
                } else if (ch.equalsIgnoreCase("/")) {
                    st.push(ch1 / ch2);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        if (st.size() > 1) {
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            st.push(Long.valueOf(sb.reverse().toString()));
        }
        return st.pop();
    }

    public static void gotOper(String ch, int prec1, Stack<String> st, Queue<String> sb) {
        while (!st.isEmpty()) {
            String stTop = st.pop();
            if (stTop.equalsIgnoreCase("(")) {
                st.push(stTop);
                break;
            } else {
                int prec2 = 0;
                if (stTop.equalsIgnoreCase("+") || stTop.equalsIgnoreCase("-")) {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec1 >= prec2) {
                    sb.add(stTop);
                } else {
                    st.push(stTop);
                    break;
                }
            }
        }
        st.push(ch);
    }

    public static void gotParan(String ch, Stack<String> st, Queue<String> sb) {
        while (!st.isEmpty()) {
            String ch2 = st.pop();
            if (ch2.equalsIgnoreCase("(")) {
                break;
            } else {
                sb.add(ch2);
            }
        }
    }

}
