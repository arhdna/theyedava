package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by shravan on 30/8/16.
 * http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
 */
public class ValidParanthesis {

    public static void main(String[] args) {
        System.out.print(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                st.push(s.charAt(i));
            } else if (!st.isEmpty()) {
                char tmp = st.pop();
                if (s.charAt(i) != map.get(tmp)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
