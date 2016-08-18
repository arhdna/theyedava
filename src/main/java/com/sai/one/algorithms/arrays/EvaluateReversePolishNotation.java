package com.sai.one.algorithms.arrays;

import java.util.Stack;

/**
 * Created by shravan
 */
public class EvaluateReversePolishNotation {
    public static void main(String args[]) {
        String[] string = {"4", "13", "5", "/", "+"};
        Stack<Integer> stc = new Stack<Integer>();
        String operator = "+-/*";
        for (int i = 0; i < string.length; i++) {
            if (operator.contains(string[i])) {
                Integer a = stc.pop();
                Integer b = stc.pop();
                switch (operator.indexOf(string[i])) {
                    case 0:
                        stc.push(a + b);
                        break;
                    case 1:
                        stc.push(b - a);
                        break;
                    case 3:
                        stc.push(a * b);
                        break;
                    case 2:
                        stc.push(b / a);
                        break;
                }
            } else {
                stc.push(Integer.valueOf(string[i]));
            }
        }
        System.out.print(stc.pop());
    }

}
